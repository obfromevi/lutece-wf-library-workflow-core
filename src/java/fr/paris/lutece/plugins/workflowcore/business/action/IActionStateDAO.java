package fr.paris.lutece.plugins.workflowcore.business.action;

import java.util.List;

public interface IActionStateDAO {

	/**
     * Insert a new record in the table workflow_action_state_before.
     *
     * @param nIdAction
     *            nIdAction of the Action object to insert
     * @param listIdStateBefore
     * 			list of the id state before
     */
    void insert( int nIdAction, List<Integer> listIdStateBefore );

    /**
     * Load the the list of id stateBefore linked to an action
     * 
     * @param nIdAction
     *            the state id
     * @return the List of id state before
     */
    List<Integer> load( int nIdAction );
    
    /**
     * Load the the list of id stateBefore linked to an action
     * 
     * @param nIdAction
     *            the state id
     * @return the List of id state before
     */
    List<String> load( String strUidAction );
    
    /**
     * Delete the action Object
     * 
     * @param nIdAction
     *            the action id
     */
     void delete( int nIdAction );
}
