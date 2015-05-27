
/**
 * GestionNiveauServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package tn.rnu.isetsf.service.parametres;

    /**
     *  GestionNiveauServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class GestionNiveauServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public GestionNiveauServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public GestionNiveauServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getCoursOfNiveauArray method
            * override this method for handling normal response from getCoursOfNiveauArray operation
            */
           public void receiveResultgetCoursOfNiveauArray(
                    tn.rnu.isetsf.service.parametres.GestionNiveauServiceStub.GetCoursOfNiveauArrayResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCoursOfNiveauArray operation
           */
            public void receiveErrorgetCoursOfNiveauArray(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getNiveausArray method
            * override this method for handling normal response from getNiveausArray operation
            */
           public void receiveResultgetNiveausArray(
                    tn.rnu.isetsf.service.parametres.GestionNiveauServiceStub.GetNiveausArrayResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getNiveausArray operation
           */
            public void receiveErrorgetNiveausArray(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modifierNiveau method
            * override this method for handling normal response from modifierNiveau operation
            */
           public void receiveResultmodifierNiveau(
                    tn.rnu.isetsf.service.parametres.GestionNiveauServiceStub.ModifierNiveauResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifierNiveau operation
           */
            public void receiveErrormodifierNiveau(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEtudiantsOfNiveauArray method
            * override this method for handling normal response from getEtudiantsOfNiveauArray operation
            */
           public void receiveResultgetEtudiantsOfNiveauArray(
                    tn.rnu.isetsf.service.parametres.GestionNiveauServiceStub.GetEtudiantsOfNiveauArrayResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEtudiantsOfNiveauArray operation
           */
            public void receiveErrorgetEtudiantsOfNiveauArray(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getNiveauById method
            * override this method for handling normal response from getNiveauById operation
            */
           public void receiveResultgetNiveauById(
                    tn.rnu.isetsf.service.parametres.GestionNiveauServiceStub.GetNiveauByIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getNiveauById operation
           */
            public void receiveErrorgetNiveauById(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for creerNiveau method
            * override this method for handling normal response from creerNiveau operation
            */
           public void receiveResultcreerNiveau(
                    tn.rnu.isetsf.service.parametres.GestionNiveauServiceStub.CreerNiveauResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from creerNiveau operation
           */
            public void receiveErrorcreerNiveau(java.lang.Exception e) {
            }
                


    }
    