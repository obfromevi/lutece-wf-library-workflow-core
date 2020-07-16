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
package fr.paris.lutece.plugins.workflowcore.service.resource;

import java.util.List;

import javax.inject.Inject;

import fr.paris.lutece.plugins.workflowcore.business.resource.IResourceHistoryDAO;
import fr.paris.lutece.plugins.workflowcore.business.resource.IResourceUserHistoryDAO;
import fr.paris.lutece.plugins.workflowcore.business.resource.ResourceHistory;
import fr.paris.lutece.plugins.workflowcore.service.action.IActionService;

/**
 *
 * ResourceHistoryService
 *
 */
public class ResourceHistoryService implements IResourceHistoryService
{
    public static final String BEAN_SERVICE = "workflow.resourceHistoryService";
    @Inject
    private IResourceHistoryDAO _resourceHistoryDAO;
    @Inject
    private IResourceUserHistoryDAO _resourceUserHistoryDAO;
    @Inject
    private IActionService _actionService;

    /**
     * {@inheritDoc}
     */
    @Override
    public void create( ResourceHistory resourceHistory )
    {
        _resourceHistoryDAO.insert( resourceHistory );
        if ( resourceHistory.getResourceUserHistory( ) != null )
        {
            // insert new Resource User History
            resourceHistory.getResourceUserHistory( ).setIdHistory( resourceHistory.getId( ) );
            _resourceUserHistoryDAO.insert( resourceHistory.getResourceUserHistory( ) );
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove( int nIdHistory )
    {
        _resourceUserHistoryDAO.delete( nIdHistory );
        _resourceHistoryDAO.delete( nIdHistory );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeByListIdResource( List<Integer> listIdResource, String strResourceType, Integer nIdWorflow )
    {
        // delete user history before delete hisory resource
        List<Integer> listRessourceHistoryToDelete = _resourceHistoryDAO.getListHistoryIdByListIdResourceId( listIdResource, strResourceType, nIdWorflow );
        listRessourceHistoryToDelete.forEach( x -> _resourceUserHistoryDAO.delete( x ) );

        _resourceHistoryDAO.deleteByListIdResource( listIdResource, strResourceType, nIdWorflow );
    }

    // FINDERS

    /**
     * {@inheritDoc}
     */
    @Override
    public ResourceHistory findByPrimaryKey( int nIdHistory )
    {
        ResourceHistory resourceHistory = _resourceHistoryDAO.load( nIdHistory );

        if ( resourceHistory != null )
        {
            resourceHistory.setAction( _actionService.findByPrimaryKey( resourceHistory.getAction( ).getId( ) ) );
            resourceHistory.setResourceUserHistory( _resourceUserHistoryDAO.load( resourceHistory.getId( ) ) );
        }

        return resourceHistory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> getListHistoryIdByListIdResourceId( List<Integer> listIdResource, String strResourceType, Integer nIdWorflow )
    {
        return _resourceHistoryDAO.getListHistoryIdByListIdResourceId( listIdResource, strResourceType, nIdWorflow );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ResourceHistory> getAllHistoryByResource( int nIdResource, String strResourceType, int nIdWorkflow )
    {
        List<ResourceHistory> listResourceHistory = _resourceHistoryDAO.selectByResource( nIdResource, strResourceType, nIdWorkflow );

        for ( ResourceHistory resourceHistory : listResourceHistory )
        {
            resourceHistory.setAction( _actionService.findByPrimaryKey( resourceHistory.getAction( ).getId( ) ) );
            resourceHistory.setResourceUserHistory( _resourceUserHistoryDAO.load( resourceHistory.getId( ) ) );
        }

        return listResourceHistory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ResourceHistory> getAllHistoryByAction( int nIdAction )
    {
        List<ResourceHistory> listResourceHistory = _resourceHistoryDAO.selectByAction( nIdAction );

        for ( ResourceHistory resourceHistory : listResourceHistory )
        {
            resourceHistory.setAction( _actionService.findByPrimaryKey( resourceHistory.getAction( ).getId( ) ) );
        }

        return listResourceHistory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResourceHistory getLastHistoryResource( int nIdResource, String strResourceType, int nIdWorkflow )
    {
        List<ResourceHistory> listResourceHistory = _resourceHistoryDAO.selectByResource( nIdResource, strResourceType, nIdWorkflow );

        for ( ResourceHistory resourceHistory : listResourceHistory )
        {
            resourceHistory.setAction( _actionService.findByPrimaryKey( resourceHistory.getAction( ).getId( ) ) );
            resourceHistory.setResourceUserHistory( _resourceUserHistoryDAO.load( resourceHistory.getId( ) ) );
        }

        return ( listResourceHistory.size( ) > 0 ) ? listResourceHistory.get( 0 ) : null;
    }
}
