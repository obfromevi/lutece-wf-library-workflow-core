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

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.paris.lutece.api.user.User;
import fr.paris.lutece.plugins.workflowcore.business.action.Action;
import fr.paris.lutece.plugins.workflowcore.business.task.ITaskType;

/**
 *
 * ITask
 *
 */
public interface ITask
{
    /**
     * @return the task Id
     */
    int getId( );

    /**
     * @param nId
     *            the task id
     */
    void setId( int nId );

    /**
     * @return the TaskType Object
     */
    ITaskType getTaskType( );

    /**
     * @param taskType
     *            the task type object
     */
    void setTaskType( ITaskType taskType );
    
    /**
     * @return the task Uid
     */
	String getUid();

    /**
     * @param strUid
     *            the task uid
     */
	void setUid( String strUid );
	
    /**
     * @return the action Uid linked to the task
     */
	public String getActionUid( );
	
    /**
     * @param strActionUid
     *            the action Uid linked to the task
     */
    public void setActionUid( String strActionUid );

    /**
     * @return the action associate to the task
     */
    Action getAction( );

    /**
     * @param action
     *            the action associate to the task
     */
    void setAction( Action action );

    /**
     * Process the task
     * 
     * @param nIdResourceHistory
     *            the resource history id
     * @param request
     *            the request
     * @param locale
     *            locale
     * @deprecated use {@link ITask#processTask(int, HttpServletRequest, Locale, User)}
     */
    @Deprecated
    default void processTask( int nIdResourceHistory, HttpServletRequest request, Locale locale )
    {
    	// nothing to do by default
    }

    /**
     * Process the task
     * 
     * @param nIdResourceHistory
     *            the resource history id
     * @param request
     *            the request
     * @param locale
     *            locale
     * @param user
     *            the user
     */
    default void processTask( int nIdResourceHistory, HttpServletRequest request, Locale locale, User user )
    {
    	// call deprecated method for compatibility
        processTask( nIdResourceHistory, request, locale );
    }

    /**
     * Process the task and send a boolean result : 
     *  - if true : next resource state will be the default "state_after"
     *  - if false : next resource state will be the alternative "state_after"
     *  
     * @param nIdResourceHistory
     * @param request
     * @param locale
     * @param user
     * @return true by default, false to set the alternative state
     */
    default boolean processTaskWithResult( int nIdResourceHistory, HttpServletRequest request, Locale locale, User user )
    {
    	// call default method if this one is not overriden, and return true by default
        processTask( nIdResourceHistory, request, locale, user );
        return true;
    }
    
    /**
     * returns the task title
     * 
     * @param locale
     *            locale
     * @return the task title
     */
    String getTitle( Locale locale );

    /**
     * returns the entries of the task form
     * 
     * @param locale
     *            locale
     * @return the entries of the task form
     */
    Map<String, String> getTaskFormEntries( Locale locale );

    /**
     * Initialize the task
     */
    void init( );

    /**
     * Remove taskInformation associate to the history
     * 
     * @param nIdHistory
     *            the document id
     */
    void doRemoveTaskInformation( int nIdHistory );

    /**
     * Remove the task configuration
     */
    void doRemoveConfig( );

    /**
     * get the order of a task
     * 
     * @return the order of the task(to display in lists)
     */
    int getOrder( );

    /**
     * set the order of an task
     * 
     * @param nOrder
     *            the order
     */
    void setOrder( int nOrder );

    /**
     * Anonymize taskInformation associate to the history
     * 
     * @param nIdHistory
     *            the document id
     */
    default void doAnonymizeTaskInformation( int nIdHistory )
    {
        doRemoveTaskInformation( nIdHistory );
    }
}
