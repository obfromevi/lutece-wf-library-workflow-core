/*
 * Copyright (c) 2002-2021, City of Paris
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
package fr.paris.lutece.plugins.workflowcore.service.task;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import fr.paris.lutece.plugins.workflowcore.business.action.Action;
import fr.paris.lutece.plugins.workflowcore.business.task.ITaskType;

/**
 *
 * Task
 *
 */

@JsonIgnoreProperties( ignoreUnknown = true )
public abstract class Task implements ITask
{
    @JsonIgnore
    private int _nId;
    private String _strUid;
    private ITaskType _taskType;
    @JsonIgnore
    private Action _action;
    private String _strActionUid;
    private int _nOrder;

    /**
     * {@inheritDoc}
     */
    @JsonIgnore
    public int getId( )
    {
        return _nId;
    }

    /**
     * {@inheritDoc}
     */
    @JsonIgnore
    public void setId( int nId )
    {
        _nId = nId;
    }
    
  /**
     * {@inheritDoc}
     */
    @Override
    public String getUid( )
    {  
        return _strUid;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUid( String strUid )
    {
    	_strUid = strUid;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ITaskType getTaskType( )
    {
        return _taskType;
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
     * {@inheritDoc}
     */
    @JsonIgnore
    public Action getAction( )
    {
        return _action;
    }

    /**
     * {@inheritDoc}
     */
    @JsonIgnore
    public void setAction( Action action )
    {
        _action = action;
    }

    /**
     * get the order of a task
     * 
     * @return the order of the task(to display in lists)
     */
    public int getOrder( )
    {
        return _nOrder;
    }

    /**
     * set the order of an task
     * 
     * @param nOrder
     *            the order
     */
    public void setOrder( int nOrder )
    {
        this._nOrder = nOrder;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String getActionUid( )
    {  
        return _strActionUid;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setActionUid( String strActionUid )
    {
    	_strActionUid = strActionUid;
    }
}
