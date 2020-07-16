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
 * TaskType
 *
 */
public class TaskType implements ITaskType
{
    private String _strTitleI18nKey;
    private String _strTitle;
    private String _strBeanName;
    private String _strConfigBeanName;
    private String _strKey;
    private boolean _bIsConfigureRequire;
    private boolean _bIsFormTaskRequire;
    private boolean _bIsTaskForAutomaticAction;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getKey( )
    {
        return _strKey;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setKey( String strKey )
    {
        _strKey = strKey;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTitleI18nKey( )
    {
        return _strTitleI18nKey;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTitleI18nKey( String strTitleI18nKey )
    {
        _strTitleI18nKey = strTitleI18nKey;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getBeanName( )
    {
        return _strBeanName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBeanName( String strBeanName )
    {
        _strBeanName = strBeanName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getConfigBeanName( )
    {
        return _strConfigBeanName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setConfigBeanName( String strConfigBeanName )
    {
        _strConfigBeanName = strConfigBeanName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTitle( )
    {
        return _strTitle;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTitle( String strTitle )
    {
        _strTitle = strTitle;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isConfigRequired( )
    {
        return _bIsConfigureRequire;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setConfigRequired( boolean bIsConfigRequired )
    {
        _bIsConfigureRequire = bIsConfigRequired;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isFormTaskRequired( )
    {
        return _bIsFormTaskRequire;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setFormTaskRequired( boolean bIsFormTaskRequired )
    {
        _bIsFormTaskRequire = bIsFormTaskRequired;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isTaskForAutomaticAction( )
    {
        return _bIsTaskForAutomaticAction;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTaskForAutomaticAction( boolean bIsTaskForAutomaticAction )
    {
        _bIsTaskForAutomaticAction = bIsTaskForAutomaticAction;
    }
}
