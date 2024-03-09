package Proj5;

import Components.*;
import DataObjects.DataInteger;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class PhaseController {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Controller";
        pn.SetName("Controller");
        pn.NetworkPort = 1082;

        DataString ini = new DataString();
        //ini.Printable = false;
        ini.SetName("ini");
        ini.SetValue("red");
        pn.ConstantPlaceList.add(ini);

        DataString red = new DataString();
        //red.Printable = false;
        red.SetName("red");
        red.SetValue("red");
        pn.ConstantPlaceList.add(red);

        DataString green = new DataString();
        //green.Printable = false;
        green.SetName("green");
        green.SetValue("green");
        pn.ConstantPlaceList.add(green);

        DataString yellow = new DataString();
        //yellow.Printable = false;
        yellow.SetName("yellow");
        yellow.SetValue("yellow");
        pn.ConstantPlaceList.add(yellow);

        DataString r1r2r3r4 = new DataString();
        r1r2r3r4.SetName("r1r2r3r4");
        r1r2r3r4.SetValue("signal");
        pn.PlaceList.add(r1r2r3r4);

        DataString g1r2r3r4 = new DataString();
        g1r2r3r4.SetName("g1r2r3r4");
        pn.PlaceList.add(g1r2r3r4);

        DataString y1r2r3r4 = new DataString();
        y1r2r3r4.SetName("y1r2r3r4");
        pn.PlaceList.add(y1r2r3r4);

        DataString r1g2r3r4 = new DataString();
        r1g2r3r4.SetName("r1g2r3r4");
        pn.PlaceList.add(r1g2r3r4);

        DataString r1y2r3r4 = new DataString();
        r1y2r3r4.SetName("r1y2r3r4");
        pn.PlaceList.add(r1y2r3r4);

        DataString r1r2g3r4 = new DataString();
        r1r2g3r4.SetName("r1r2g3r4");
        pn.PlaceList.add(r1r2g3r4);

        DataString r1r2y3r4 = new DataString();
        r1r2y3r4.SetName("r1r2y3r4");
        pn.PlaceList.add(r1r2y3r4);

        DataString r1r2r3g4 = new DataString();
        r1r2r3g4.SetName("r1r2r3g4");
        pn.PlaceList.add(r1r2r3g4);

        DataString r1r2r3y4 = new DataString();
        r1r2r3y4.SetName("r1r2r3y4");
        pn.PlaceList.add(r1r2r3y4);



        // OPs
        DataTransfer op1 = new DataTransfer();
        op1.SetName("OP1");
        op1.Value = new TransferOperation("localhost", "1080" , "P_TL1");
        pn.PlaceList.add(op1);

        DataTransfer op2 = new DataTransfer();
        op2.SetName("OP2");
        op2.Value = new TransferOperation("localhost", "1080" , "P_TL2");
        pn.PlaceList.add(op2);

        DataTransfer op3 = new DataTransfer();
        op3.SetName("OP3");
        op3.Value = new TransferOperation("localhost", "1080" , "P_TL3");
        pn.PlaceList.add(op3);

        DataTransfer op4 = new DataTransfer();
        op4.SetName("OP4");
        op4.Value = new TransferOperation("localhost", "1080" , "P_TL4");
        pn.PlaceList.add(op4);



        // Ins Places
        DataString in1 = new DataString();
        in1.SetName("in1");
        pn.PlaceList.add(in1);

        DataString in2 = new DataString();
        in2.SetName("in2");
        pn.PlaceList.add(in2);

        DataString in3 = new DataString();
        in3.SetName("in3");
        pn.PlaceList.add(in3);

        DataString in4 = new DataString();
        in4.SetName("in4");
        pn.PlaceList.add(in4);



        // Five&Ten + delay
        DataInteger Five = new DataInteger();
        Five.SetName("Five");
        Five.SetValue(5);
        pn.ConstantPlaceList.add(Five);

        DataInteger Ten = new DataInteger();
        Ten.SetName("Ten");
        Ten.SetValue(10);
        pn.ConstantPlaceList.add(Ten);



        //----------------------------iniT------------------------------------
        PetriTransition iniT = new PetriTransition(pn);
        iniT.TransitionName = "iniT";

        Condition iniTCt1 = new Condition(iniT, "ini", TransitionCondition.NotNull);

        GuardMapping grdiniT = new GuardMapping();
        grdiniT.condition= iniTCt1;

        grdiniT.Activations.add(new Activation(iniT, "ini", TransitionOperation.SendOverNetwork, "OP1"));
        grdiniT.Activations.add(new Activation(iniT, "ini", TransitionOperation.SendOverNetwork, "OP2"));
        grdiniT.Activations.add(new Activation(iniT, "ini", TransitionOperation.SendOverNetwork, "OP3"));
        grdiniT.Activations.add(new Activation(iniT, "ini", TransitionOperation.SendOverNetwork, "OP4"));
        grdiniT.Activations.add(new Activation(iniT, "", TransitionOperation.MakeNull, "ini"));

        iniT.GuardMappingList.add(grdiniT);

        iniT.Delay = 0;
        pn.Transitions.add(iniT);


        //----------------------------T1------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "T1";
        t1.InputPlaceName.add("r1r2r3r4");

        Condition T1Ct1 = new Condition(t1, "r1r2r3r4", TransitionCondition.NotNull);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition= T1Ct1;
        grdT1.Activations.add(new Activation(t1, "r1r2r3r4", TransitionOperation.Move, "g1r2r3r4"));
        grdT1.Activations.add(new Activation(t1, "green", TransitionOperation.SendOverNetwork, "OP1"));
        t1.GuardMappingList.add(grdT1);

        t1.Delay = 5;
        pn.Transitions.add(t1);

        //----------------------------T2------------------------------------
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "T2";
        t2.InputPlaceName.add("g1r2r3r4");
        t2.InputPlaceName.add("in1");
//        t2.InputPlaceName.add("delay");

        //for the first grd
        Condition T2Ct1 = new Condition(t2, "g1r2r3r4", TransitionCondition.NotNull);
        Condition T2Ct2 = new Condition(t2, "in1", TransitionCondition.IsNull);
        T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);

        GuardMapping grdT21 = new GuardMapping();
        grdT21.condition = T2Ct1;
        grdT21.Activations.add(new Activation(t2, "g1r2r3r4", TransitionOperation.Move, "y1r2r3r4"));
        grdT21.Activations.add(new Activation(t2, "yellow", TransitionOperation.SendOverNetwork, "OP1"));
        grdT21.Activations.add(new Activation(t2, "Five", TransitionOperation.DynamicDelay,""));
        t2.GuardMappingList.add(grdT21);

        //for the second grd
        Condition T2Ct4 = new Condition(t2, "g1r2r3r4", TransitionCondition.NotNull);
        Condition T2Ct5 = new Condition(t2, "in1", TransitionCondition.NotNull);
        T2Ct4.SetNextCondition(LogicConnector.AND, T2Ct5);

        GuardMapping grdT22 = new GuardMapping();
        grdT22.condition = T2Ct4;
        grdT22.Activations.add(new Activation(t2, "g1r2r3r4", TransitionOperation.Move, "y1r2r3r4"));
        grdT22.Activations.add(new Activation(t2, "Ten", TransitionOperation.DynamicDelay,""));
        grdT22.Activations.add(new Activation(t2, "yellow", TransitionOperation.SendOverNetwork, "OP1"));
        t2.GuardMappingList.add(grdT22);

        t2.Delay = 5;
        pn.Transitions.add(t2);


        //----------------------------T3------------------------------------
        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "T3";
        t3.InputPlaceName.add("y1r2r3r4");

        Condition T3Ct1 = new Condition(t3, "y1r2r3r4", TransitionCondition.NotNull);

        GuardMapping grdT3 = new GuardMapping();
        grdT3.condition= T3Ct1;
        grdT3.Activations.add(new Activation(t3, "y1r2r3r4", TransitionOperation.Move, "r1g2r3r4"));
        grdT3.Activations.add(new Activation(t3, "red", TransitionOperation.SendOverNetwork, "OP1"));
        grdT3.Activations.add(new Activation(t3, "green", TransitionOperation.SendOverNetwork, "OP2"));
        t3.GuardMappingList.add(grdT3);

        t3.Delay = 5;
        pn.Transitions.add(t3);


        //----------------------------T4------------------------------------
        PetriTransition t4 = new PetriTransition(pn);
        t4.TransitionName = "T4";
        t4.InputPlaceName.add("r1g2r3r4");
        t4.InputPlaceName.add("in2");

        //for the first grd
        Condition T4Ct1 = new Condition(t4, "r1g2r3r4", TransitionCondition.NotNull);
        Condition T4Ct2 = new Condition(t4, "in2", TransitionCondition.IsNull);
        T4Ct1.SetNextCondition(LogicConnector.AND, T4Ct2);

        GuardMapping grdT4 = new GuardMapping();
        grdT4.condition= T4Ct1;
        grdT4.Activations.add(new Activation(t4, "r1g2r3r4", TransitionOperation.Move, "r1y2r3r4"));
        grdT4.Activations.add(new Activation(t4, "yellow", TransitionOperation.SendOverNetwork, "OP2"));
        grdT4.Activations.add(new Activation(t4, "Five", TransitionOperation.DynamicDelay,""));
        t4.GuardMappingList.add(grdT4);


        //for the second grd
        Condition T4Ct4 = new Condition(t4, "r1g2r3r4", TransitionCondition.NotNull);
        Condition T4Ct5 = new Condition(t4, "in2", TransitionCondition.NotNull);
        T4Ct4.SetNextCondition(LogicConnector.AND, T4Ct5);

        GuardMapping grdT42 = new GuardMapping();
        grdT42.condition = T4Ct4;
        grdT42.Activations.add(new Activation(t4, "r1g2r3r4", TransitionOperation.Move, "r1y2r3r4"));
        grdT42.Activations.add(new Activation(t4, "Ten", TransitionOperation.DynamicDelay,""));
        grdT42.Activations.add(new Activation(t4, "yellow", TransitionOperation.SendOverNetwork, "OP2"));

        t4.Delay = 5;
        pn.Transitions.add(t4);


        //----------------------------T5------------------------------------
        PetriTransition t5 = new PetriTransition(pn);
        t5.TransitionName = "T5";
        t5.InputPlaceName.add("r1y2r3r4");

        Condition T5Ct1 = new Condition(t5, "r1y2r3r4", TransitionCondition.NotNull);

        GuardMapping grdT5 = new GuardMapping();
        grdT5.condition= T5Ct1;
        grdT5.Activations.add(new Activation(t5, "r1y2r3r4", TransitionOperation.Move, "r1r2g3r4"));
        grdT5.Activations.add(new Activation(t5, "red", TransitionOperation.SendOverNetwork, "OP2"));
        grdT5.Activations.add(new Activation(t5, "green", TransitionOperation.SendOverNetwork, "OP3"));
        t5.GuardMappingList.add(grdT5);

        t5.Delay = 5;
        pn.Transitions.add(t5);


        //----------------------------T6------------------------------------
        PetriTransition t6 = new PetriTransition(pn);
        t6.TransitionName = "T6";
        t6.InputPlaceName.add("r1r2g3r4");
        t6.InputPlaceName.add("in3");

        //for the first grd
        Condition T6Ct1 = new Condition(t6, "r1r2g3r4", TransitionCondition.NotNull);
        Condition T6Ct2 = new Condition(t6, "in3", TransitionCondition.IsNull);
        T6Ct1.SetNextCondition(LogicConnector.AND, T6Ct2);

        GuardMapping grdT6 = new GuardMapping();
        grdT6.condition= T6Ct1;
        grdT6.Activations.add(new Activation(t6, "r1r2g3r4", TransitionOperation.Move, "r1r2y3r4"));
        grdT6.Activations.add(new Activation(t6, "yellow", TransitionOperation.SendOverNetwork, "OP3"));
        grdT6.Activations.add(new Activation(t6, "Five", TransitionOperation.DynamicDelay,""));
        t6.GuardMappingList.add(grdT6);

        //for the second grd
        Condition T6Ct4 = new Condition(t6, "r1r2g3r4", TransitionCondition.NotNull);
        Condition T6Ct5 = new Condition(t6, "in3", TransitionCondition.NotNull);
        T6Ct4.SetNextCondition(LogicConnector.AND, T6Ct5);

        GuardMapping grdT62 = new GuardMapping();
        grdT62.condition = T6Ct4;
        grdT62.Activations.add(new Activation(t6, "r1r2g3r4", TransitionOperation.Move, "r1r2y3r4"));
        grdT62.Activations.add(new Activation(t6, "Ten", TransitionOperation.DynamicDelay,""));
        grdT62.Activations.add(new Activation(t6, "yellow", TransitionOperation.SendOverNetwork, "OP3"));

        t6.Delay = 5;
        pn.Transitions.add(t6);


        //----------------------------T7------------------------------------
        PetriTransition t7 = new PetriTransition(pn);
        t7.TransitionName = "T7";
        t7.InputPlaceName.add("r1r2y3r4");

        Condition T7Ct1 = new Condition(t7, "r1r2y3r4", TransitionCondition.NotNull);

        GuardMapping grdT7 = new GuardMapping();
        grdT7.condition= T7Ct1;
        grdT7.Activations.add(new Activation(t7, "r1r2y3r4", TransitionOperation.Move, "r1r2r3g4"));
        grdT7.Activations.add(new Activation(t7, "red", TransitionOperation.SendOverNetwork, "OP3"));
        grdT7.Activations.add(new Activation(t7, "green", TransitionOperation.SendOverNetwork, "OP4"));
        t7.GuardMappingList.add(grdT7);

        t7.Delay = 5;
        pn.Transitions.add(t7);




        //----------------------------T8------------------------------------
        PetriTransition t8 = new PetriTransition(pn);
        t8.TransitionName = "T8";
        t8.InputPlaceName.add("r1r2r3g4");
        t8.InputPlaceName.add("in4");

        //for the first grd
        Condition T8Ct1 = new Condition(t8, "r1r2r3g4", TransitionCondition.NotNull);
        Condition T8Ct2 = new Condition(t8, "in4", TransitionCondition.IsNull);
        T8Ct1.SetNextCondition(LogicConnector.AND, T8Ct2);

        GuardMapping grdT8 = new GuardMapping();
        grdT8.condition= T8Ct1;
        grdT8.Activations.add(new Activation(t8, "r1r2r3g4", TransitionOperation.Move, "r1r2r3y4"));
        grdT8.Activations.add(new Activation(t8, "yellow", TransitionOperation.SendOverNetwork, "OP4"));
        grdT8.Activations.add(new Activation(t8, "Five", TransitionOperation.DynamicDelay,""));
        t8.GuardMappingList.add(grdT8);

        //for the second grd
        Condition T8Ct4 = new Condition(t8, "r1r2r3g4", TransitionCondition.NotNull);
        Condition T8Ct5 = new Condition(t8, "in4", TransitionCondition.NotNull);
        T8Ct4.SetNextCondition(LogicConnector.AND, T8Ct5);

        GuardMapping grdT82 = new GuardMapping();
        grdT82.condition = T8Ct4;
        grdT82.Activations.add(new Activation(t8, "r1r2r3g4", TransitionOperation.Move, "r1r2r3y4"));
        grdT82.Activations.add(new Activation(t8, "Ten", TransitionOperation.DynamicDelay,""));
        grdT82.Activations.add(new Activation(t8, "yellow", TransitionOperation.SendOverNetwork, "OP4"));

        t8.Delay = 5;
        pn.Transitions.add(t8);



        //----------------------------T9------------------------------------
        PetriTransition t9 = new PetriTransition(pn);
        t9.TransitionName = "T9";
        t9.InputPlaceName.add("r1r2r3y4");

        Condition T9Ct1 = new Condition(t7, "r1r2r3y4", TransitionCondition.NotNull);

        GuardMapping grdT9 = new GuardMapping();
        grdT9.condition= T9Ct1;
        grdT9.Activations.add(new Activation(t9, "r1r2r3y4", TransitionOperation.Move, "r1r2r3r4"));
        grdT9.Activations.add(new Activation(t9, "red", TransitionOperation.SendOverNetwork, "OP4"));
        t9.GuardMappingList.add(grdT9);

        t9.Delay = 5;
        pn.Transitions.add(t9);


        // -------------------------------------------------------------------------------------
        // ----------------------------PN Start-------------------------------------------------
        // -------------------------------------------------------------------------------------

        System.out.println("Exp1 started \n ------------------------------");
        pn.Delay = 2000;
        // pn.Start();

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);
    }
}
