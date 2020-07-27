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
package fr.paris.lutece.plugins.workflowcore.business.prerequisite;

/**
 * Business class of prerequisites
 */
public class Prerequisite
{
    private int _nPrerequisiteId;
    private String _strPrerequisiteType;
    private int _nIdAction;

    /**
     * Get the id of this prerequisite
     * 
     * @return The id of this prerequisite
     */
    public int getIdPrerequisite( )
    {
        return _nPrerequisiteId;
    }

    /**
     * Set the id of this prerequisite
     * 
     * @param nIdPrerequisite
     *            The id of this prerequisite
     */
    public void setIdPrerequisite( int nIdPrerequisite )
    {
        this._nPrerequisiteId = nIdPrerequisite;
    }

    /**
     * Get the type of the prerequisite
     * 
     * @return The type of the prerequisite
     */
    public String getPrerequisiteType( )
    {
        return _strPrerequisiteType;
    }

    /**
     * Set the type of the prerequisite
     * 
     * @param strPrerequisiteType
     *            The type of the prerequisite
     */
    public void setPrerequisiteType( String strPrerequisiteType )
    {
        this._strPrerequisiteType = strPrerequisiteType;
    }

    /**
     * Get the id of the action associated with this prerequisite
     * 
     * @return The id of the action associated with this prerequisite
     */
    public int getIdAction( )
    {
        return _nIdAction;
    }

    /**
     * Set the id of the action associated with this prerequisite
     * 
     * @param nIdAction
     *            The id of the action associated with this prerequisite
     */
    public void setIdAction( int nIdAction )
    {
        this._nIdAction = nIdAction;
    }
}
