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
package fr.paris.lutece.plugins.workflowcore.business.resource;

import java.io.Serializable;

/**
 * This is the business class for the object ResourceUserHistory
 */
public class ResourceUserHistory implements Serializable
{

    private static final long serialVersionUID = 1L;

    private int _nIdHistory;
    private String _strUserAccessCode;
    private String _strEmail;
    private String _strFirstname;
    private String _strLastname;
    private String _strRealm;

    /**
     * ResourceUserHistory constructor
     */
    public ResourceUserHistory( )
    {

    }

    /**
     * ResourceUserHistory constructor
     * 
     * @param strUserAccessCode
     *            the user access code
     * @param strEmail
     *            the user email
     * @param strFirstname
     *            the user first name
     * @param strLastname
     *            the user last name
     * @param strRealm
     *            the user realm
     */
    public ResourceUserHistory( String strUserAccessCode, String strEmail, String strFirstname, String strLastname, String strRealm )
    {
        super( );
        this._strUserAccessCode = strUserAccessCode;
        this._strEmail = strEmail;
        this._strFirstname = strFirstname;
        this._strLastname = strLastname;
        this._strRealm = strRealm;
    }

    /**
     * Returns the IdHistory
     * 
     * @return The IdHistory
     */
    public int getIdHistory( )
    {
        return _nIdHistory;
    }

    /**
     * Sets the IdHistory
     * 
     * @param nIdHistory
     *            The IdHistory
     */
    public void setIdHistory( int nIdHistory )
    {
        _nIdHistory = nIdHistory;
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

    /**
     * Returns the Email
     * 
     * @return The Email
     */
    public String getEmail( )
    {
        return _strEmail;
    }

    /**
     * Sets the Email
     * 
     * @param strEmail
     *            The Email
     */
    public void setEmail( String strEmail )
    {
        _strEmail = strEmail;
    }

    /**
     * Returns the Firstname
     * 
     * @return The Firstname
     */
    public String getFirstName( )
    {
        return _strFirstname;
    }

    /**
     * Sets the Firstname
     * 
     * @param strFirstname
     *            The Firstname
     */
    public void setFirstName( String strFirstname )
    {
        _strFirstname = strFirstname;
    }

    /**
     * Returns the Lastname
     * 
     * @return The Lastname
     */
    public String getLastName( )
    {
        return _strLastname;
    }

    /**
     * Sets the Lastname
     * 
     * @param strLastname
     *            The Lastname
     */
    public void setLastName( String strLastname )
    {
        _strLastname = strLastname;
    }

    /**
     * Returns the Realm
     * 
     * @return The Realm
     */
    public String getRealm( )
    {
        return _strRealm;
    }

    /**
     * Sets the Realm
     * 
     * @param strRealm
     *            The Realm
     */
    public void setRealm( String strRealm )
    {
        _strRealm = strRealm;
    }
}
