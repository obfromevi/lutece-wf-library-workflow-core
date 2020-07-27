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
package fr.paris.lutece.plugins.workflowcore.service.task;

import fr.paris.lutece.plugins.workflowcore.business.task.ITaskDAO;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

/**
 *
 * TaskService
 *
 */
public class TaskService implements ITaskService
{
    public static final String BEAN_SERVICE = "workflow.taskService";
    @Inject
    private ITaskDAO _taskDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    public void create( ITask task )
    {
        _taskDAO.insert( task );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update( ITask task )
    {
        _taskDAO.store( task );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove( int nIdTask )
    {
        _taskDAO.delete( nIdTask );
    }

    // FINDERS

    /**
     * {@inheritDoc}
     */
    @Override
    public ITask findByPrimaryKey( int nIdTask, Locale locale )
    {
        return _taskDAO.load( nIdTask, locale );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ITask> getListTaskByIdAction( int nIdAction, Locale locale )
    {
        return _taskDAO.selectTaskByIdAction( nIdAction, locale );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int findMaximumOrderByActionId( int nIdAction )
    {
        return _taskDAO.findMaximumOrderByActionId( nIdAction );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void decrementOrderByOne( int nOrder, int nIdAction )
    {
        _taskDAO.decrementOrderByOne( nOrder, nIdAction );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ITask> findTasksBetweenOrders( int nOrder1, int nOrder2, int nIdAction, Locale locale )
    {
        return _taskDAO.findTasksBetweenOrders( nOrder1, nOrder2, nIdAction, locale );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ITask> findTasksAfterOrder( int nOrder, int nIdAction, Locale locale )
    {
        return _taskDAO.findTasksAfterOrder( nOrder, nIdAction, locale );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initializeTaskOrder( int nIdAction, Locale locale )
    {
        List<ITask> listTask = _taskDAO.findTasksForOrderInit( nIdAction, locale );
        int nOrder = 1;

        for ( ITask task : listTask )
        {
            task.setOrder( nOrder );
            update( task );
            nOrder++;
        }
    }
}
