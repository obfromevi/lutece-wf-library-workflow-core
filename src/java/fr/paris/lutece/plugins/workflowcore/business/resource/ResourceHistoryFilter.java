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
package fr.paris.lutece.plugins.workflowcore.business.resource;

import java.util.List;

/**
 *
 * ResourceHistory
 *
 */
public class ResourceHistoryFilter
{
    // Variables declarations
    public static final int ALL_INT = -1;
    private List<Integer> _listIdResources;
    private String _strResourceType;
    private int _nIdWorkflow = ALL_INT;
    private int _nIdAction = ALL_INT;
    private String _strUserAccessCode;

    /**
     * Returns the IdResources
     * 
     * @return The IdResources
     */
    public List<Integer> getListIdResources( )
    {
        return _listIdResources;
    }

    /**
     * Sets the IdResources
     * 
     * @param listIdResources
     *            The IdResources
     */
    public void setListIdResources( List<Integer> listIdResources )
    {
        _listIdResources = listIdResources;
    }

    /**
     * Returns the ResourceType
     * 
     * @return The ResourceType
     */
    public String getResourceType( )
    {
        return _strResourceType;
    }

    /**
     * Sets the ResourceType
     * 
     * @param strResourceType
     *            The ResourceType
     */
    public void setResourceType( String strResourceType )
    {
        _strResourceType = strResourceType;
    }

    /**
     * Returns the IdWorkflow
     * 
     * @return The IdWorkflow
     */
    public int getIdWorkflow( )
    {
        return _nIdWorkflow;
    }

    /**
     * Sets the IdWorkflow
     * 
     * @param nIdWorkflow
     *            The IdWorkflow
     */
    public void setIdWorkflow( int nIdWorkflow )
    {
        _nIdWorkflow = nIdWorkflow;
    }

    /**
     * Returns the IdAction
     * 
     * @return The IdAction
     */
    public int getIdAction( )
    {
        return _nIdAction;
    }

    /**
     * Sets the IdAction
     * 
     * @param nIdAction
     *            The IdAction
     */
    public void setIdAction( int nIdAction )
    {
        _nIdAction = nIdAction;
    }

    /**
     * Returns the UserAccessCode
     * 
     * @return The UserAccessCode
     */
    public String getUserAccessCode( )
    {
        return _strUserAccessCode;
    }

    /**
     * Sets the UserAccessCode
     * 
     * @param strUserAccessCode
     *            The UserAccessCode
     */
    public void setUserAccessCode( String strUserAccessCode )
    {
        _strUserAccessCode = strUserAccessCode;
    }
}
