
/**
 * GestionNoteServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package tn.rnu.isetsf.service.compostage;

    /**
     *  GestionNoteServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class GestionNoteServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public GestionNoteServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public GestionNoteServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getNotesArray method
            * override this method for handling normal response from getNotesArray operation
            */
           public void receiveResultgetNotesArray(
                    tn.rnu.isetsf.service.compostage.GestionNoteServiceStub.GetNotesArrayResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getNotesArray operation
           */
            public void receiveErrorgetNotesArray(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getNoteById method
            * override this method for handling normal response from getNoteById operation
            */
           public void receiveResultgetNoteById(
                    tn.rnu.isetsf.service.compostage.GestionNoteServiceStub.GetNoteByIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getNoteById operation
           */
            public void receiveErrorgetNoteById(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for creerNote method
            * override this method for handling normal response from creerNote operation
            */
           public void receiveResultcreerNote(
                    tn.rnu.isetsf.service.compostage.GestionNoteServiceStub.CreerNoteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from creerNote operation
           */
            public void receiveErrorcreerNote(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modifierNote method
            * override this method for handling normal response from modifierNote operation
            */
           public void receiveResultmodifierNote(
                    tn.rnu.isetsf.service.compostage.GestionNoteServiceStub.ModifierNoteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifierNote operation
           */
            public void receiveErrormodifierNote(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getValeursOfNoteArray method
            * override this method for handling normal response from getValeursOfNoteArray operation
            */
           public void receiveResultgetValeursOfNoteArray(
                    tn.rnu.isetsf.service.compostage.GestionNoteServiceStub.GetValeursOfNoteArrayResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getValeursOfNoteArray operation
           */
            public void receiveErrorgetValeursOfNoteArray(java.lang.Exception e) {
            }
                


    }
    