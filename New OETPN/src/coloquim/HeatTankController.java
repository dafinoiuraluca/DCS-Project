package coloquim;

import Components.*;
import DataObjects.*;
import DataOnly.SubPetri;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class HeatTankController {
    public static PetriNet Monitor() {
        PetriNet mnt = new PetriNet();
        mnt.PetriNetName = "Monitor";
        mnt.NetworkPort = 1081;

        DataString P10 = new DataString();
        P10.SetName("P10");
        mnt.PlaceList.add(P10);

        DataFloat P11 = new DataFloat();
        P11.SetName("P11");
        mnt.PlaceList.add(P11);

        // T6
        PetriTransition t6 = new PetriTransition(mnt);
        t6.TransitionName = "T6";
        t6.InputPlaceName.add("P10");

        Condition T6Ct1 = new Condition(t6, "P10", TransitionCondition.NotNull);

        GuardMapping grdT6 = new GuardMapping();
        grdT6.condition = T6Ct1;
        grdT6.Activations.add(new Activation(t6, "P10", TransitionOperation.Copy, "P11"));

        return mnt;
    }
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "HTC";
        pn.NetworkPort = 1080;

        DataSubPetriNet monitor = new DataSubPetriNet();
        monitor.SetName("Monitor");
        SubPetri pn2 = new SubPetri(Monitor());
        monitor.SetValue(pn2);
        pn.ConstantPlaceList.add(monitor);

        // Input channels
        DataFloat P1 = new DataFloat();
        P1.SetName("P1");
        pn.PlaceList.add(P1);

        DataFloat P3 = new DataFloat();
        P3.SetName("P3");
        pn.PlaceList.add(P3);

        DataFloat P0 = new DataFloat();
        P0.SetName("P0");
        pn.PlaceList.add(P0);

        DataFloat P2 = new DataFloat();
        P2.SetName("P2");
        pn.PlaceList.add(P2);

        DataFloat P4 = new DataFloat();
        P4.SetName("P4");
        pn.PlaceList.add(P4);

        DataFloat P5 = new DataFloat();
        P5.SetName("P5");
        pn.PlaceList.add(P5);

        DataFloat P6 = new DataFloat();
        P6.SetName("P6");
        pn.PlaceList.add(P6);

        DataFloat P7 = new DataFloat();
        P7.SetName("P7");
        pn.PlaceList.add(P7);

        DataFloat P8 = new DataFloat();
        P8.SetName("P8");
        pn.PlaceList.add(P8);

        DataTransfer P7Send = new DataTransfer();
        P7Send.SetName("P7Send");
        P7Send.Value = new TransferOperation("localhost", "1081", "P10");
        pn.PlaceList.add(P7Send);


        DataFloat p12constValue = new DataFloat();
        p12constValue.SetValue(1.2f);
        p12constValue.SetName("p12constValue");
        pn.ConstantPlaceList.add(p12constValue);


        // T0
        PetriTransition t0 = new PetriTransition(pn);
        t0.TransitionName = "T0";
        t0.InputPlaceName.add("P0");
        t0.InputPlaceName.add("P1");

        Condition T0Ct1 = new Condition(t0, "P0", TransitionCondition.NotNull);
        Condition T0Ct2 = new Condition(t0, "P1", TransitionCondition.NotNull);
        T0Ct1.SetNextCondition(LogicConnector.AND, T0Ct2);

        GuardMapping grdT0 = new GuardMapping();
        grdT0.condition = T0Ct1;
        grdT0.Activations.add(new Activation(t0, "P1", TransitionOperation.Move, "P2"));

        t0.GuardMappingList.add(grdT0);
        t0.Delay = 0;
        pn.Transitions.add(t0);


        // T1
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "T1";
        t1.InputPlaceName.add("P2");
        t1.InputPlaceName.add("P3");

        Condition T1Ct1 = new Condition(t1, "P2", TransitionCondition.NotNull);
        Condition T1Ct2 = new Condition(t1, "P3", TransitionCondition.NotNull);
        T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition = T1Ct1;
        grdT1.Activations.add(new Activation(t1, "P1", TransitionOperation.Sub, "P3"));
        grdT1.Activations.add(new Activation(t1, "P3", TransitionOperation.Move, "P4"));
        grdT1.Activations.add(new Activation(t1, "P3", TransitionOperation.Move, "P5"));

        t1.GuardMappingList.add(grdT1);
        t1.Delay = 0;
        pn.Transitions.add(t1);


        // T3
        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "T3";
        t3.InputPlaceName.add("P5");

        Condition T3Ct1 = new Condition(t1, "P5", TransitionCondition.NotNull);

        GuardMapping grdT3 = new GuardMapping();
        grdT3.condition = T3Ct1;
        grdT3.Activations.add(new Activation(t3, "P5", TransitionOperation.Move, "P0"));
        t3.GuardMappingList.add(grdT3);

        t3.Delay = 1;
        pn.Transitions.add(t3);

        // T4
        PetriTransition t4 = new PetriTransition(pn);
        t4.TransitionName = "T4";
        t4.InputPlaceName.add("P4");
        t4.InputPlaceName.add("P6");

        Condition T4Ct1 = new Condition(t4, "P4", TransitionCondition.LessThanOrEqual, "p12constValue");
        Condition T4Ct2 = new Condition(t4, "P6", TransitionCondition.NotNull);
        T4Ct1.SetNextCondition(LogicConnector.AND, T4Ct2);

        GuardMapping grdT4 = new GuardMapping();
        grdT4.condition = T4Ct1;
        grdT4.Activations.add(new Activation(t4, "P4", TransitionOperation.Add, "P6"));
        grdT4.Activations.add(new Activation(t4, "P6", TransitionOperation.Move, "P7"));
        grdT4.Activations.add(new Activation(t4, "P6", TransitionOperation.Move, "P8"));
        t4.GuardMappingList.add(grdT4);

        t4.Delay = 0;
        pn.Transitions.add(t4);


        // T5
        PetriTransition t5 = new PetriTransition(pn);
        t5.TransitionName = "T5";
        t5.InputPlaceName.add("P8");

        Condition T5Ct1 = new Condition(t5, "P8", TransitionCondition.NotNull);

        GuardMapping grdT5 = new GuardMapping();
        grdT5.condition = T5Ct1;
        grdT5.Activations.add(new Activation(t5, "P8", TransitionOperation.Move, "P6"));
        t5.GuardMappingList.add(grdT5);

        t5.Delay = 0;
        pn.Transitions.add(t5);


        // T2
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "T2";
        t2.InputPlaceName.add("P7");

        Condition T2Ct1 = new Condition(t2, "P7", TransitionCondition.NotNull);

        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition = T2Ct1;
        grdT2.Activations.add(new Activation(t2, "P7", TransitionOperation.SendPetriNetOverNetwork, "P10"));
        t2.GuardMappingList.add(grdT2);

        t2.Delay = 0;
        pn.Transitions.add(t2);


        System.out.println("HTC started \n ------------------------------");
        pn.Delay = 5000;

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);

    }
}
