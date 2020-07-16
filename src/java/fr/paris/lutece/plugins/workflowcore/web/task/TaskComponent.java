/*
 * Copyright (c) 2002-2020, City of Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.workflowcore.web.task;

import fr.paris.lutece.plugins.workflowcore.business.config.ITaskConfig;
import fr.paris.lutece.plugins.workflowcore.business.task.ITaskType;
import fr.paris.lutece.plugins.workflowcore.service.config.ITaskConfigService;
import fr.paris.lutece.plugins.workflowcore.service.task.ITask;
import fr.paris.lutece.plugins.workflowcore.service.task.ITaskFactory;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import org.apache.log4j.Logger;

import org.springframework.util.Assert;

import java.lang.reflect.InvocationTargetException;

import java.util.Locale;

import javax.inject.Inject;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * TaskComponent
 *
 */
public abstract class TaskComponent implements ITaskComponent
{
    private static final String PARAMETER_APPLY = "apply";
    private static Logger _logger = Logger.getLogger( "lutece.workflow" );
    private ITaskType _taskType;
    private ITaskConfigService _taskConfigService;
    @Inject
    private ITaskFactory _taskFactory;

    /**
     * Validate the config
     * 
     * @param config
     *            the config to validate
     * @param request
     *            the HTTP request
     * @return the JSP error if the config is not validated, an empty String otherwise
     */
    public abstract String validateConfig( ITaskConfig config, HttpServletRequest request );

    /**
     * {@inheritDoc}
     */
    @Override
    public String doSaveConfig( HttpServletRequest request, Locale locale, ITask task )
    {
        // In case there are no errors, then the config is created/updated
        boolean bCreate = false;
        ITaskConfig config = _taskConfigService.findByPrimaryKey( task.getId( ) );

        if ( config == null )
        {
            config = _taskFactory.newTaskConfig( _taskType.getKey( ) );

            if ( config != null )
            {
                config.setIdTask( task.getId( ) );
                bCreate = true;
            }
        }

        if ( config != null )
        {
            try
            {
                BeanUtils.populate( config, request.getParameterMap( ) );

                String strApply = request.getParameter( PARAMETER_APPLY );

                // Check if the AdminUser clicked on "Apply" or on "Save"
                if ( StringUtils.isEmpty( strApply ) )
                {
                    String strJspError = this.validateConfig( config, request );

                    if ( StringUtils.isNotBlank( strJspError ) )
                    {
                        return strJspError;
                    }
                }

                if ( bCreate )
                {
                    _taskConfigService.create( config );
                }
                else
                {
                    _taskConfigService.update( config );
                }
            }
            catch( InvocationTargetException | IllegalAccessException e )
            {
                _logger.error( e.getMessage( ), e );
            }
        }
        else
        {
            _logger.error( "TaskComponent - could not instanciate a new TaskConfig for type " + _taskType.getKey( ) );
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTaskType( ITaskType taskType )
    {
        _taskType = taskType;
    }

    /**
     * Set the task config service
     * 
     * @param taskConfigService
     *            the task config service
     */
    public void setTaskConfigService( ITaskConfigService taskConfigService )
    {
        _taskConfigService = taskConfigService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isInvoked( String strKey )
    {
        if ( ( _taskType != null ) && StringUtils.isNotBlank( _taskType.getKey( ) ) && StringUtils.isNotBlank( strKey ) )
        {
            return _taskType.getKey( ).equals( strKey );
        }

        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void afterPropertiesSet( ) throws Exception
    {
        Assert.notNull( _taskType, "The property 'taskType' is required." );

        if ( _taskType.isConfigRequired( ) )
        {
            Assert.notNull( _taskConfigService, "The property 'taskConfigService' is required." );
        }
    }

    /**
     * Get the task config service
     * 
     * @return the task config service
     */
    protected ITaskConfigService getTaskConfigService( )
    {
        return _taskConfigService;
    }
}
