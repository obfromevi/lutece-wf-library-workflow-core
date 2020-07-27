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
package fr.paris.lutece.plugins.workflowcore.business.task;

import fr.paris.lutece.plugins.workflowcore.service.task.ITask;

import java.util.List;
import java.util.Locale;

/**
 *
 * ITaskDAO
 *
 */
public interface ITaskDAO
{
    /**
     * Insert a new record in the table.
     *
     * @param task
     *            instance of the Task object to insert
     */
    void insert( ITask task );

    /**
     * update record in the table.
     *
     * @param task
     *            instance of the task object to update
     */
    void store( ITask task );

    /**
     * Load the task Object
     * 
     * @param nIdTask
     *            the task id
     * @param locale
     *            the locale
     * @return the Action Object
     */
    ITask load( int nIdTask, Locale locale );

    /**
     * Delete the task Object
     * 
     * @param nIdTask
     *            the task id
     */
    void delete( int nIdTask );

    /**
     * select all task associated width the action specified in parameter
     * 
     * @param nIdAction
     *            the action id
     * @param locale
     *            the locale
     * @return a list of ITask
     */
    List<ITask> selectTaskByIdAction( int nIdAction, Locale locale );

    /**
     * return the maximum order number of the tasks in a given workflow
     * 
     * @param nIdAction
     *            the action id
     * @return the maximum order of the tasks in the given action
     */
    int findMaximumOrderByActionId( int nIdAction );

    /**
     * decrements the order of all the next tasks after the one which will be removed
     * 
     * @param nOrder
     *            the order id
     * @param nIdAction
     *            the action id
     */
    void decrementOrderByOne( int nOrder, int nIdAction );

    /**
     * Finds all the tasks which have an order lower to a given order
     * 
     * @param nOrder1
     *            the order 1
     * @param nOrder2
     *            the order 2
     * @param nIdAction
     *            the action id
     * @param locale
     *            the locale
     * @return List<ITask> the list of all the tasks
     */
    List<ITask> findTasksBetweenOrders( int nOrder1, int nOrder2, int nIdAction, Locale locale );

    /**
     * Finds all the tasks which have an order greater to a given order
     * 
     * @param nOrder
     *            the order
     * @param nIdAction
     *            the action id
     * @param locale
     *            the locale
     * @return List<ITask> the list of all the tasks
     */
    List<ITask> findTasksAfterOrder( int nOrder, int nIdAction, Locale locale );

    /**
     * Finds all the tasks for the given action ordered by id
     * 
     * @param nIdAction
     *            the action id
     * @param locale
     *            the locale
     * @return List<Task> the list of all the tasks
     */
    List<ITask> findTasksForOrderInit( int nIdAction, Locale locale );
}
