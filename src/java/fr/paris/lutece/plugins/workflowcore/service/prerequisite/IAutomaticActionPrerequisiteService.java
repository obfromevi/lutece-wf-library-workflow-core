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
package fr.paris.lutece.plugins.workflowcore.service.prerequisite;

import fr.paris.lutece.plugins.workflowcore.business.prerequisite.IPrerequisiteConfig;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

/**
 * Interface for prerequisite services of automatic actions.<br />
 * Before processing an automatic action, every prerequisite of the action are checked. If one of them failed, the action is not performed. If they all succeed,
 * the action is performed.<br />
 * The default implementation of plugin workflow also provide a daemon to check if resources validates prerequisites of automatic actions. If they do, the
 * action is performed.<br />
 * <br />
 * <b>Implementations of this interface must be declared as Spring beans.</b>
 */
public interface IAutomaticActionPrerequisiteService
{
    /**
     * Get the type of prerequisites associated with this service
     * 
     * @return The type of prerequisites associated with this service
     */
    String getPrerequisiteType( );

    /**
     * Get the I18n key of the title of the prerequisite
     * 
     * @return the I18n key of the title of the prerequisite
     */
    String getTitleI18nKey( );

    /**
     * Check if the prerequisite type of the this service needs a configuration
     * 
     * @return True if the prerequisite type need a configuration, false otherwise
     */
    boolean hasConfiguration( );

    /**
     * Get a new instance of the configuration of this prerequisite type.<br />
     * The configuration bean must implement the interface {@link fr.paris.lutece.plugins.workflowcore.business.prerequisite.IPrerequisiteConfig
     * IPrerequisiteConfig}
     * 
     * @return A new instance of the configuration of this prerequisite type, or null if the prerequisite has no configuration
     */
    IPrerequisiteConfig getEmptyConfiguration( );

    /**
     * Get the bean name of the DAO for configurations of this prerequisite type.<br />
     * The configuration bean must implement the interface {@link fr.paris.lutece.plugins.workflowcore.business.prerequisite.IPrerequisiteConfigDAO
     * IPrerequisiteConfigDAO}
     * 
     * @return The name of the bean of the configuration, or null if the prerequisite has no configuration
     */
    String getConfigurationDaoBeanName( );

    /**
     * Get the HTML form to create or modify a configuration for a new prerequisite.<br />
     * The returned HTML will be inserted into a HTML frameset that already contains a form tag.<br />
     * Data entered by the user will be saved into the configuration bean with populating methods. The bean will also be validated before it is saved.
     * 
     * @param config
     *            The configuration to display the form of
     * @param request
     *            The request
     * @param locale
     *            The locale
     * @return The HTML content to display, or null if there is no form to display
     */
    String getConfigHtml( IPrerequisiteConfig config, HttpServletRequest request, Locale locale );

    /**
     * Check if a resource matches this prerequisite.
     * 
     * @param nIdResource
     *            The id of the resource
     * @param strResourceType
     *            The resource type
     * @param config
     *            The configuration of the prerequisite, or null if the prerequisite has no configuration
     * @param nIdAction
     *            The id of the action that will be performed if the resource matches every prerequisites
     * @return True if the resource matches this prerequisite, false otherwise
     */
    boolean canActionBePerformed( int nIdResource, String strResourceType, IPrerequisiteConfig config, int nIdAction );
}
