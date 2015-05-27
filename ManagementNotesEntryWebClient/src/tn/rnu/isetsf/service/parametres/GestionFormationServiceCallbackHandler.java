
/**
 * GestionFormationServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package tn.rnu.isetsf.service.parametres;

    /**
     *  GestionFormationServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class GestionFormationServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public GestionFormationServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public GestionFormationServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getFormationById method
            * override this method for handling normal response from getFormationById operation
            */
           public void receiveResultgetFormationById(
                    tn.rnu.isetsf.service.parametres.GestionFormationServiceStub.GetFormationByIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getFormationById operation
           */
            public void receiveErrorgetFormationById(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modifierFormation method
            * override this method for handling normal response from modifierFormation operation
            */
           public void receiveResultmodifierFormation(
                    tn.rnu.isetsf.service.parametres.GestionFormationServiceStub.ModifierFormationResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifierFormation operation
           */
            public void receiveErrormodifierFormation(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for creerFormation method
            * override this method for handling normal response from creerFormation operation
            */
           public void receiveResultcreerFormation(
                    tn.rnu.isetsf.service.parametres.GestionFormationServiceStub.CreerFormationResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from creerFormation operation
           */
            public void receiveErrorcreerFormation(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getNiveauxOfFormationArray method
            * override this method for handling normal response from getNiveauxOfFormationArray operation
            */
           public void receiveResultgetNiveauxOfFormationArray(
                    tn.rnu.isetsf.service.parametres.GestionFormationServiceStub.GetNiveauxOfFormationArrayResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getNiveauxOfFormationArray operation
           */
            public void receiveErrorgetNiveauxOfFormationArray(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getFormationsArray method
            * override this method for handling normal response from getFormationsArray operation
            */
           public void receiveResultgetFormationsArray(
                    tn.rnu.isetsf.service.parametres.GestionFormationServiceStub.GetFormationsArrayResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getFormationsArray operation
           */
            public void receiveErrorgetFormationsArray(java.lang.Exception e) {
            }
                


    }
    