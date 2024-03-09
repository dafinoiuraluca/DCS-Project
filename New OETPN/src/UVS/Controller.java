package UVS;

import Components.*;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Controller {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Controller";
        pn.NetworkPort = 1080;

        DataString red = new DataString();
        red.SetName("red");
        red.SetValue("red");
        pn.ConstantPlaceList.add(red);

        DataString green = new DataString();
        green.SetName("green");
        green.SetValue("green");
        pn.ConstantPlaceList.add(green);

        DataString yellow = new DataString();
        yellow.SetName("yellow");
        yellow.SetValue("yellow");
        pn.ConstantPlaceList.add(yellow);

        DataString r1r2 = new DataString();
        r1r2.SetName("r1r2");
        r1r2.SetValue("signal");
        pn.PlaceList.add(r1r2);

        DataString g1r2 = new DataString();
        g1r2.SetName("g1r2");
        pn.PlaceList.add(g1r2);

        DataString y1r2 = new DataString();
        y1r2.SetName("y1r2");
        pn.PlaceList.add(y1r2);

        DataString r1g2 = new DataString();
        r1g2.SetName("r1g2");
        pn.PlaceList.add(r1g2);

        DataTransfer OP1 = new DataTransfer();
        OP1.SetName("OP1");
        OP1.Value = new TransferOperation("localhost", "1081" , "P_TL1");
        pn.PlaceList.add(OP1);

        DataTransfer OP2 = new DataTransfer();
        OP2.SetName("OP2");
        OP2.Value = new TransferOperation("localhost", "1081" , "P_PL1");
        pn.PlaceList.add(OP2);

        DataString in1 = new DataString();
        in1.SetName("in1");
        pn.PlaceList.add(in1);

        DataString ini = new DataString();
        ini.SetName("ini");
        ini.SetValue("red");
        pn.ConstantPlaceList.add(ini);

        // Transitions
        //----------------------------iniT------------------------------------
        PetriTransition iniT = new PetriTransition(pn);
        iniT.TransitionName = "iniT";

        Condition iniTCt1 = new Condition(iniT, "ini", TransitionCondition.NotNull);

        GuardMapping grdiniT = new GuardMapping();
        grdiniT.condition= iniTCt1;

        grdiniT.Activations.add(new Activation(iniT, "ini", TransitionOperation.SendOverNetwork, "OP1"));
        grdiniT.Activations.add(new Activation(iniT, "ini", TransitionOperation.SendOverNetwork, "OP2"));
        grdiniT.Activations.add(new Activation(iniT, "", TransitionOperation.MakeNull, "ini"));

        iniT.GuardMappingList.add(grdiniT);

        iniT.Delay = 0;
        pn.Transitions.add(iniT);


        // T0-----------------------------------------------------------------------------------------------------------
        PetriTransition t0 = new PetriTransition(pn);
        t0.TransitionName = "T0";
        t0.InputPlaceName.add("r1r2");

        Condition T0Ct1 = new Condition(t0, "r1r2", TransitionCondition.NotNull);

        GuardMapping grdT0 = new GuardMapping();
        grdT0.condition= T0Ct1;
        grdT0.Activations.add(new Activation(t0, "r1r2", TransitionOperation.Move, "g1r2"));
        grdT0.Activations.add(new Activation(t0, "green", TransitionOperation.SendOverNetwork, "OP1"));
        grdT0.Activations.add(new Activation(t0, "red", TransitionOperation.SendOverNetwork, "OP2"));
        t0.GuardMappingList.add(grdT0);

        t0.Delay = 5;
        pn.Transitions.add(t0);


        // T1-----------------------------------------------------------------------------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "T1";
        t1.InputPlaceName.add("g1r2");
        t1.InputPlaceName.add("in1");

        Condition T1Ct1 = new Condition(t1, "g1r2", TransitionCondition.NotNull);
        Condition T1Ct2 = new Condition(t1, "in1", TransitionCondition.IsNull);
        T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition= T1Ct1;
        grdT1.Activations.add(new Activation(t1, "g1r2", TransitionOperation.Move, "y1r2"));
        grdT1.Activations.add(new Activation(t1, "yellow", TransitionOperation.SendOverNetwork, "OP1"));
        t1.GuardMappingList.add(grdT1);

        t1.Delay = 5;
        pn.Transitions.add(t1);


        // T2-----------------------------------------------------------------------------------------------------------
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "T2";
        t2.InputPlaceName.add("y1r2");

        Condition T2Ct1 = new Condition(t2, "y1r2", TransitionCondition.NotNull);

        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition = T2Ct1;
        grdT2.Activations.add(new Activation(t2, "y1r2", TransitionOperation.Move, "r1g2"));
        grdT2.Activations.add(new Activation(t2, "red", TransitionOperation.SendOverNetwork, "OP1"));
        grdT2.Activations.add(new Activation(t2, "green", TransitionOperation.SendOverNetwork, "OP2"));
        t2.GuardMappingList.add(grdT2);

        t2.Delay = 5;
        pn.Transitions.add(t2);


        // T3-----------------------------------------------------------------------------------------------------------
        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "T3";
        t3.InputPlaceName.add("r1g2");

        Condition T3Ct1 = new Condition(t3, "r1g2", TransitionCondition.NotNull);

        GuardMapping grdT3 = new GuardMapping();
        grdT3.condition= T3Ct1;
        grdT3.Activations.add(new Activation(t3, "r1g2", TransitionOperation.Move, "r1r2"));
        grdT3.Activations.add(new Activation(t3, "red", TransitionOperation.SendOverNetwork, "OP1"));
        grdT3.Activations.add(new Activation(t3, "red", TransitionOperation.SendOverNetwork, "OP2"));
        t3.GuardMappingList.add(grdT3);

        t3.Delay = 5;
        pn.Transitions.add(t3);

        System.out.println("Controller started \n ------------------------------");
        pn.Delay = 2000;

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);

    }
}
