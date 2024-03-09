package Proiect.Intersectie2;

import Components.*;
import DataObjects.DataCar;
import DataObjects.DataCarQueue;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class MiddleStreet {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Middle Street";
        pn.NetworkPort = 1084;

        // Places

        // WHEN going out from round about
        DataCar P_oli2 = new DataCar();
        P_oli2.SetName("P_oli2");
        pn.PlaceList.add(P_oli2);

        DataCarQueue P1 = new DataCarQueue();
        P1.SetName("P1");
        P1.Value.Size = 5;
        pn.PlaceList.add(P1);

        DataCar P2 = new DataCar();
        P2.SetName("P2");
        pn.PlaceList.add(P2);

        DataTransfer Ii4 = new DataTransfer();
        Ii4.SetName("I_i4");
        Ii4.Value = new TransferOperation("localhost", "1082" , "P_ai4");
        pn.PlaceList.add(Ii4);

        // GOING IN round about
        DataCar E_oli3 = new DataCar();
        E_oli3.SetName("E_oli3");
        pn.PlaceList.add(E_oli3);

        DataCarQueue P3 = new DataCarQueue();
        P3.SetName("P3");
        P3.Value.Size = 5;
        pn.PlaceList.add(P3);

        DataCar P4 = new DataCar();
        P4.SetName("P4");
        pn.PlaceList.add(P4);

        DataTransfer Ii2 = new DataTransfer();
        Ii2.SetName("I_i2");
        Ii2.Value = new TransferOperation("localhost", "1081" , "i2");
        pn.PlaceList.add(Ii2);


        // Transitions

        // T1-----------------------------------------------------------------------------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "T1";
        t1.InputPlaceName.add("P_oli2");

        Condition T1Ct1 = new Condition(t1, "P_oli2", TransitionCondition.NotNull);
        Condition T1Ct2 = new Condition(t1, "P1", TransitionCondition.CanAddCars);
        T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition= T1Ct1;
        grdT1.Activations.add(new Activation(t1, "P_oli2", TransitionOperation.AddElement, "P1"));
        t1.GuardMappingList.add(grdT1);

        t1.Delay = 0;
        pn.Transitions.add(t1);


        // T2-----------------------------------------------------------------------------------------------------------
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "T2";
        t2.InputPlaceName.add("P1");

        Condition T2Ct1 = new Condition(t2, "P1", TransitionCondition.HaveCar);

        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition= T2Ct1;
        grdT2.Activations.add(new Activation(t2, "P1", TransitionOperation.PopElementWithoutTarget, "P2"));
        t2.GuardMappingList.add(grdT2);

        t2.Delay = 0;
        pn.Transitions.add(t2);


        // T3-----------------------------------------------------------------------------------------------------------
        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "T3";
        t3.InputPlaceName.add("P2");

        Condition T3Ct1 = new Condition(t3, "P2", TransitionCondition.NotNull);

        GuardMapping grdT3 = new GuardMapping();
        grdT3.condition= T3Ct1;
        grdT3.Activations.add(new Activation(t3, "P2", TransitionOperation.SendOverNetwork, "I_i4"));
        t3.GuardMappingList.add(grdT3);

        t3.Delay = 0;
        pn.Transitions.add(t3);


        // T4-----------------------------------------------------------------------------------------------------------
        PetriTransition t4 = new PetriTransition(pn);
        t4.TransitionName = "T4";
        t4.InputPlaceName.add("E_oli3");

        Condition T4Ct1 = new Condition(t4, "E_oli3", TransitionCondition.NotNull);
        Condition T4Ct2 = new Condition(t4, "P3", TransitionCondition.CanAddCars);
        T4Ct1.SetNextCondition(LogicConnector.AND, T4Ct2);

        GuardMapping grdT4 = new GuardMapping();
        grdT4.condition= T4Ct1;
        grdT4.Activations.add(new Activation(t4, "E_oli3", TransitionOperation.AddElement, "P3"));
        t4.GuardMappingList.add(grdT4);

        t4.Delay = 0;
        pn.Transitions.add(t4);


        // T5-----------------------------------------------------------------------------------------------------------
        PetriTransition t5 = new PetriTransition(pn);
        t5.TransitionName = "T5";
        t5.InputPlaceName.add("P3");

        Condition T5Ct1 = new Condition(t5, "P3", TransitionCondition.HaveCar);

        GuardMapping grdT5 = new GuardMapping();
        grdT5.condition= T5Ct1;
        grdT5.Activations.add(new Activation(t5, "P3", TransitionOperation.PopElementWithoutTarget, "P4"));
        t5.GuardMappingList.add(grdT5);

        t5.Delay = 0;
        pn.Transitions.add(t5);


        // T6-----------------------------------------------------------------------------------------------------------
        PetriTransition t6 = new PetriTransition(pn);
        t6.TransitionName = "T6";
        t6.InputPlaceName.add("P4");

        Condition T6Ct1 = new Condition(t6, "P4", TransitionCondition.NotNull);

        GuardMapping grdT6 = new GuardMapping();
        grdT6.condition= T6Ct1;
        grdT6.Activations.add(new Activation(t6, "P4", TransitionOperation.SendOverNetwork, "I_i2"));
        t6.GuardMappingList.add(grdT6);

        t6.Delay = 0;
        pn.Transitions.add(t6);


        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);

        System.out.println("Exp1 started \n ------------------------------");
        pn.Delay = 2000;
    }
}
