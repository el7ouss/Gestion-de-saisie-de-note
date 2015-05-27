
/**
 * GestionCourServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package tn.rnu.isetsf.service.parametres;

    /**
     *  GestionCourServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class GestionCourServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public GestionCourServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public GestionCourServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getCourById method
            * override this method for handling normal response from getCourById operation
            */
           public void receiveResultgetCourById(
                    tn.rnu.isetsf.service.parametres.GestionCourServiceStub.GetCourByIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCourById operation
           */
            public void receiveErrorgetCourById(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modifierCour method
            * override this method for handling normal response from modifierCour operation
            */
           public void receiveResultmodifierCour(
                    tn.rnu.isetsf.service.parametres.GestionCourServiceStub.ModifierCourResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifierCour operation
           */
            public void receiveErrormodifierCour(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for creerCour method
            * override this method for handling normal response from creerCour operation
            */
           public void receiveResultcreerCour(
                    tn.rnu.isetsf.service.parametres.GestionCourServiceStub.CreerCourResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from creerCour operation
           */
            public void receiveErrorcreerCour(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCoursArray method
            * override this method for handling normal response from getCoursArray operation
            */
           public void receiveResultgetCoursArray(
                    tn.rnu.isetsf.service.parametres.GestionCourServiceStub.GetCoursArrayResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCoursArray operation
           */
            public void receiveErrorgetCoursArray(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getNotesOfCourArray method
            * override this method for handling normal response from getNotesOfCourArray operation
            */
           public void receiveResultgetNotesOfCourArray(
                    tn.rnu.isetsf.service.parametres.GestionCourServiceStub.GetNotesOfCourArrayResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getNotesOfCourArray operation
           */
            public void receiveErrorgetNotesOfCourArray(java.lang.Exception e) {
            }
                


    }
    