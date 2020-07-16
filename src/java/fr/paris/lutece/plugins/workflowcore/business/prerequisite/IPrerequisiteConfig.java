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

import java.io.Serializable;

/**
 * Interface of beans that describe prerequisite configuration
 */
public interface IPrerequisiteConfig extends Serializable
{
    /**
     * Get the id of the prerequisite associated with this configuration
     * 
     * @return The id of the prerequisite associated with this configuration
     */
    int getIdPrerequisite( );

    /**
     * Set the id of the prerequisite associated with this configuration
     * 
     * @param nId
     *            The id of the prerequisite associated with this configuration
     */
    void setIdPrerequisite( int nId );

    /**
     * Get the type of the prerequisite service associated with this configuration
     * 
     * @return the type of the prerequisite service associated with this configuration
     */
    String getPrerequisiteType( );

    /**
     * Set the type of the prerequisite associated with this configuration
     * 
     * @param strPrerequisiteType
     *            the type of the prerequisite service associated with this configuration
     */
    void setPrerequisiteType( String strPrerequisiteType );
}
