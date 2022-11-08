package fr.paris.lutece.plugins.workflowcore.service.action;

import java.util.List;

public interface IActionStateService {
	
	public static final String BEAN_SERVICE = "workflow.actionStateService";
	
	/**
     * Creation of an instance of action
     * 
     * @param action
     *            The instance of action which contains the informations to store
     */
    void create( int idAction, List<Integer> listIdStateBefore );

    /**
     * Update of action which is specified in parameter
     * 
     * @param action
     *            The instance of action which contains the informations to update
     */
    void update( int idAction, List<Integer> listIdStateBefore );

    /**
     * Remove action which is specified in parameter
     * 
     * @param nIdAction
     *            The action id which contains the informations to remove
     */
    void remove( int nIdAction );
    
    // /////////////////////////////////////////////////////////////////////////
    // Finders

    /**
     * Load the Action Object
     * 
     * @param nIdAction
     *            the action id
     * @return the Action Object
     */
    List<Integer> findByIdAction( int nIdAction );

}
