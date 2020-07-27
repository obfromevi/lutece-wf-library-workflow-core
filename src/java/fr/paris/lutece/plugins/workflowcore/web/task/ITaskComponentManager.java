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

import fr.paris.lutece.plugins.workflowcore.service.task.ITask;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * ITaskComponentManager
 *
 */
public interface ITaskComponentManager
{
    /**
     * Get the list of task components
     * 
     * @return a list of {@link ITaskComponent}
     */
    List<ITaskComponent> getTaskComponents( );

    /**
     * Get the task component from a given key
     * 
     * @param strKey
     *            the key
     * @return an instance of {@link ITaskComponent}
     */
    ITaskComponent getTaskComponent( String strKey );

    /**
     * Get the task component from a given task
     * 
     * @param task
     *            the task
     * @return an instance of {@link ITaskComponent}
     */
    ITaskComponent getTaskComponent( ITask task );

    /**
     * Returns the informations which must be displayed in the tasks form
     * 
     * @param nIdResource
     *            the resource id
     * @param strResourceType
     *            the resource type
     * @param request
     *            request
     * @param locale
     *            locale
     * @param task
     *            the task
     * @return the information which must be displayed in the tasks form
     */
    String getDisplayTaskForm( int nIdResource, String strResourceType, HttpServletRequest request, Locale locale, ITask task );

    /**
     * Returns the informations which must be displayed in the task configuration
     * 
     * @param request
     *            request
     * @param locale
     *            locale
     * @param task
     *            the task
     * @return the information which must be displayed in the task configuration
     */
    String getDisplayConfigForm( HttpServletRequest request, Locale locale, ITask task );

    /**
     * Return for a document the informations store during processing task
     * 
     * @param nIdHistory
     *            the document id
     * @param request
     *            the request
     * @param locale
     *            locale
     * @param task
     *            the task
     * @return the informations store during processing task
     */
    String getDisplayTaskInformation( int nIdHistory, HttpServletRequest request, Locale locale, ITask task );

    /**
     * Return a xml which contains for a document the informations store during processing task
     * 
     * @param nIdHistory
     *            the document id
     * @param request
     *            the request
     * @param locale
     *            locale
     * @param task
     *            the task
     * @return the informations store during processing task
     */
    String getTaskInformationXml( int nIdHistory, HttpServletRequest request, Locale locale, ITask task );

    /**
     * validates the user input associated to the task
     * 
     * @param nIdResource
     *            the resource id
     * @param strResourceType
     *            the resource type
     * @param request
     *            request
     * @param locale
     *            locale
     * @param task
     *            the task
     * @return null if there is no error in the task form else return the error message url
     */
    String doValidateTask( int nIdResource, String strResourceType, HttpServletRequest request, Locale locale, ITask task );

    /**
     * Perform the task configuration
     * 
     * @param request
     *            request
     * @param locale
     *            locale
     * @param task
     *            the task
     * @return the url to go after perform task configuration
     */
    String doSaveConfig( HttpServletRequest request, Locale locale, ITask task );
}
