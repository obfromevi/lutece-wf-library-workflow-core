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

/**
 *
 * ITaskType
 *
 */
public interface ITaskType
{
    /**
     * @return key of the task type
     */
    String getKey( );

    /**
     * @param key
     *            title the key of the text type
     */
    void setKey( String key );

    /**
     * @return the I18n title key of the task type
     */
    String getTitleI18nKey( );

    /**
     * @param title
     *            the title of the task type
     */
    void setTitleI18nKey( String title );

    /**
     * @return the bean name of the task
     */
    String getBeanName( );

    /**
     * @param strBeanName
     *            the bean name of the task
     */
    void setBeanName( String strBeanName );

    /**
     * @return the task config bean name
     */
    String getConfigBeanName( );

    /**
     * @param strConfigBeanName
     *            the task config bean name
     */
    void setConfigBeanName( String strConfigBeanName );

    /**
     * @return the title of the task type
     */
    String getTitle( );

    /**
     * Set the title of the task type
     * 
     * @param title
     *            the title of the task type
     */
    void setTitle( String title );

    /**
     * @return true if the task use a configuration
     */
    boolean isConfigRequired( );

    /**
     * @param bIsConfigRequired
     *            true if the task use a configuration
     */
    void setConfigRequired( boolean bIsConfigRequired );

    /**
     * @return true if the task use a form
     */
    boolean isFormTaskRequired( );

    /**
     * @param bIsFormTaskRequired
     *            true if the task use a form
     */
    void setFormTaskRequired( boolean bIsFormTaskRequired );

    /**
     * @return true if the task may be use by automatic action
     */
    boolean isTaskForAutomaticAction( );

    /**
     * @param bIsTaskForAutomaticAction
     *            true if the task may be use by automatic action
     */
    void setTaskForAutomaticAction( boolean bIsTaskForAutomaticAction );
}
