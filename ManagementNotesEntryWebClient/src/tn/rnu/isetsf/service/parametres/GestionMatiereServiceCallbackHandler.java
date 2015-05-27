
/**
 * GestionMatiereServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package tn.rnu.isetsf.service.parametres;

    /**
     *  GestionMatiereServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class GestionMatiereServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public GestionMatiereServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public GestionMatiereServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getCoursOfMatiereArray method
            * override this method for handling normal response from getCoursOfMatiereArray operation
            */
           public void receiveResultgetCoursOfMatiereArray(
                    tn.rnu.isetsf.service.parametres.GestionMatiereServiceStub.GetCoursOfMatiereArrayResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCoursOfMatiereArray operation
           */
            public void receiveErrorgetCoursOfMatiereArray(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getMatiereById method
            * override this method for handling normal response from getMatiereById operation
            */
           public void receiveResultgetMatiereById(
                    tn.rnu.isetsf.service.parametres.GestionMatiereServiceStub.GetMatiereByIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getMatiereById operation
           */
            public void receiveErrorgetMatiereById(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for creerMatiere method
            * override this method for handling normal response from creerMatiere operation
            */
           public void receiveResultcreerMatiere(
                    tn.rnu.isetsf.service.parametres.GestionMatiereServiceStub.CreerMatiereResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from creerMatiere operation
           */
            public void receiveErrorcreerMatiere(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modifierMatiere method
            * override this method for handling normal response from modifierMatiere operation
            */
           public void receiveResultmodifierMatiere(
                    tn.rnu.isetsf.service.parametres.GestionMatiereServiceStub.ModifierMatiereResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifierMatiere operation
           */
            public void receiveErrormodifierMatiere(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getMatieresArray method
            * override this method for handling normal response from getMatieresArray operation
            */
           public void receiveResultgetMatieresArray(
                    tn.rnu.isetsf.service.parametres.GestionMatiereServiceStub.GetMatieresArrayResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getMatieresArray operation
           */
            public void receiveErrorgetMatieresArray(java.lang.Exception e) {
            }
                


    }
    