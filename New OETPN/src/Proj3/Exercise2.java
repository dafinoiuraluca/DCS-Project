package Proj3;

import Components.*;
import DataObjects.DataCar;
import DataObjects.DataCarQueue;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Exercise2 {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Main Petri";
        pn.NetworkPort = 1081;


        DataString full = new DataString();
        full.SetName("full");
        full.SetValue("full");
        pn.ConstantPlaceList.add(full);


        DataString green= new DataString();
        green.SetName("green");
        green.SetValue("green");
        green.Printable= false;
        pn.ConstantPlaceList.add(green);


        //LANE1---------------------------------------------------------------------------
        DataCar pa1 = new DataCar();
        pa1.SetName("P_a1");
        pn.PlaceList.add(pa1);

        DataCarQueue px1 = new DataCarQueue();
        px1.Value.Size = 3;
        px1.SetName("P_x1");
        pn.PlaceList.add(px1);

        DataString pTL1 = new DataString();
        pTL1.SetName("P_TL1");
        pn.PlaceList.add(pTL1);

        DataCar pb1 = new DataCar();
        pb1.SetName("P_b1");
        pn.PlaceList.add(pb1);

        DataTransfer OP1 = new DataTransfer();
        OP1.SetName("OP1");
        OP1.Value = new TransferOperation("localhost", "1080", "In");
        pn.PlaceList.add(OP1);


        //sub2---------------------------------
        DataCarQueue po1 = new DataCarQueue();
        po1.Value.Size = 3;
        po1.SetName("P_o1");
        pn.PlaceList.add(po1);

        DataString po1e = new DataString();
        po1e.SetName("P_O1E");
        pn.PlaceList.add(po1e);


        /////// Tu1 ------------------------------------------------
        PetriTransition tu1 = new PetriTransition(pn);
        tu1.TransitionName = "T_u1";
        tu1.InputPlaceName.add("P_a1");
        tu1.InputPlaceName.add("P_x1");

        Condition tu1Ctu1 = new Condition(tu1, "P_a1", TransitionCondition.NotNull);
        Condition tu1Cte1 = new Condition(tu1, "P_x1", TransitionCondition.CanAddCars);
        tu1Ctu1.SetNextCondition(LogicConnector.AND, tu1Cte1);

        GuardMapping grdtu1 = new GuardMapping();
        grdtu1.condition= tu1Ctu1;
        grdtu1.Activations.add(new Activation(tu1, "P_a1", TransitionOperation.AddElement, "P_x1"));
        tu1.GuardMappingList.add(grdtu1);

        Condition tu1Ct3 = new Condition(tu1, "P_a1", TransitionCondition.NotNull);
        Condition tu1Ct4 = new Condition(tu1, "P_x1", TransitionCondition.CanNotAddCars);
        tu1Ct3.SetNextCondition(LogicConnector.AND, tu1Ct4);

        GuardMapping grdtu11 = new GuardMapping();
        grdtu11.condition= tu1Ct3;
        grdtu11.Activations.add(new Activation(tu1, "full", TransitionOperation.SendOverNetwork, "OP1"));
        grdtu11.Activations.add(new Activation(tu1, "P_a1", TransitionOperation.Copy, "P_a1"));
        tu1.GuardMappingList.add(grdtu11);

        tu1.Delay = 0;
        pn.Transitions.add(tu1);

        ////// Te1 ------------------------------------------------
        PetriTransition te1 = new PetriTransition(pn);
        te1.TransitionName = "T_e1";
        te1.InputPlaceName.add("P_x1");
        te1.InputPlaceName.add("P_TL1");


        Condition te1Ctu1 = new Condition(te1, "P_TL1", TransitionCondition.Equal,"green");
        Condition te1Cte1 = new Condition(te1, "P_x1", TransitionCondition.HaveCar);
        te1Ctu1.SetNextCondition(LogicConnector.AND, te1Cte1);

        GuardMapping grdte1 = new GuardMapping();
        grdte1.condition= te1Ctu1;
        grdte1.Activations.add(new Activation(te1, "P_x1", TransitionOperation.PopElementWithoutTarget, "P_b1"));
        grdte1.Activations.add(new Activation(te1, "P_TL1", TransitionOperation.Move, "P_TL1"));

        te1.GuardMappingList.add(grdte1);

        te1.Delay = 0;
        pn.Transitions.add(te1);



        //////T_I1--------------------------------------------------
        PetriTransition t_i1 = new PetriTransition(pn);
        te1.TransitionName = "T_i1";
        te1.InputPlaceName.add("P_b1");
        te1.InputPlaceName.add("P_I");





        //LANE2-------------------------------------------------------------------------
        DataCar pa2 = new DataCar();
        pa2.SetName("P_a2");
        pn.PlaceList.add(pa2);

        DataCarQueue px2 = new DataCarQueue();
        px2.Value.Size = 3;
        px2.SetName("P_x2");
        pn.PlaceList.add(px2);

        DataString pTL2 = new DataString();
        pTL2.SetName("P_TL2");
        pn.PlaceList.add(pTL2);

        DataCar pb2 = new DataCar();
        pb2.SetName("P_b2");
        pn.PlaceList.add(pb2);

        DataTransfer OP2 = new DataTransfer();
        OP2.SetName("OP2");
        OP2.Value = new TransferOperation("localhost", "1080", "In");
        pn.PlaceList.add(OP2);


        /////// Tu2 ------------------------------------------------
        PetriTransition tu2 = new PetriTransition(pn);
        tu2.TransitionName = "T_u2";
        tu2.InputPlaceName.add("P_a2");
        tu2.InputPlaceName.add("P_x2");

        Condition tu2Ctu2 = new Condition(tu2, "P_a2", TransitionCondition.NotNull);
        Condition tu2Cte2 = new Condition(tu2, "P_x2", TransitionCondition.CanAddCars);
        tu2Ctu2.SetNextCondition(LogicConnector.AND, tu2Cte2);

        GuardMapping grdtu2 = new GuardMapping();
        grdtu2.condition= tu2Ctu2;
        grdtu2.Activations.add(new Activation(tu2, "P_a2", TransitionOperation.AddElement, "P_x2"));
        tu2.GuardMappingList.add(grdtu2);

        Condition tu2Ct3 = new Condition(tu2, "P_a2", TransitionCondition.NotNull);
        Condition tu2Ct4 = new Condition(tu2, "P_x1", TransitionCondition.CanNotAddCars);
        tu2Ct3.SetNextCondition(LogicConnector.AND, tu2Ct4);

        GuardMapping grdtu22 = new GuardMapping();
        grdtu22.condition= tu2Ct3;
        grdtu22.Activations.add(new Activation(tu2, "full", TransitionOperation.SendOverNetwork, "OP2"));
        grdtu22.Activations.add(new Activation(tu2, "P_a2", TransitionOperation.Copy, "P_a2"));
        tu2.GuardMappingList.add(grdtu22);

        tu2.Delay = 0;
        pn.Transitions.add(tu2);

        ////// Te1 ------------------------------------------------
        PetriTransition te2 = new PetriTransition(pn);
        te2.TransitionName = "T_e2";
        te2.InputPlaceName.add("P_x2");
        te2.InputPlaceName.add("P_TL2");


        Condition te2Ctu2 = new Condition(te2, "P_TL2", TransitionCondition.Equal,"green");
        Condition te2Cte2 = new Condition(te2, "P_x2", TransitionCondition.HaveCar);
        te2Ctu2.SetNextCondition(LogicConnector.AND, te2Cte2);

        GuardMapping grdte2 = new GuardMapping();
        grdte2.condition= te2Ctu2;
        grdte2.Activations.add(new Activation(te2, "P_x2", TransitionOperation.PopElementWithoutTarget, "P_b2"));
        grdte2.Activations.add(new Activation(te2, "P_TL2", TransitionOperation.Move, "P_TL2"));

        te2.GuardMappingList.add(grdte2);

        te2.Delay = 0;
        pn.Transitions.add(te2);





        //LANE3-------------------------------------------------------------------------------
        DataCar pa3 = new DataCar();
        pa3.SetName("P_a3");
        pn.PlaceList.add(pa3);

        DataCarQueue px3 = new DataCarQueue();
        px3.Value.Size = 3;
        px3.SetName("P_x3");
        pn.PlaceList.add(px3);

        DataString pTL3 = new DataString();
        pTL3.SetName("P_TL3");
        pn.PlaceList.add(pTL3);

        DataCar pb3 = new DataCar();
        pb3.SetName("P_b3");
        pn.PlaceList.add(pb3);

        DataTransfer OP3 = new DataTransfer();
        OP3.SetName("OP3");
        OP3.Value = new TransferOperation("localhost", "1080", "In");
        pn.PlaceList.add(OP3);


        /////// Tu3 ------------------------------------------------
        PetriTransition tu3 = new PetriTransition(pn);
        tu3.TransitionName = "T_u3";
        tu3.InputPlaceName.add("P_a3");
        tu3.InputPlaceName.add("P_x3");

        Condition tu3Ctu3 = new Condition(tu3, "P_a3", TransitionCondition.NotNull);
        Condition tu3Cte3 = new Condition(tu3, "P_x3", TransitionCondition.CanAddCars);
        tu3Ctu3.SetNextCondition(LogicConnector.AND, tu3Cte3);

        GuardMapping grdtu3 = new GuardMapping();
        grdtu3.condition= tu3Ctu3;
        grdtu3.Activations.add(new Activation(tu3, "P_a3", TransitionOperation.AddElement, "P_x3"));
        tu3.GuardMappingList.add(grdtu3);

        Condition tu3Ct3 = new Condition(tu3, "P_a3", TransitionCondition.NotNull);
        Condition tu3Ct4 = new Condition(tu3, "P_x3", TransitionCondition.CanNotAddCars);
        tu2Ct3.SetNextCondition(LogicConnector.AND, tu3Ct4);

        GuardMapping grdtu33 = new GuardMapping();
        grdtu33.condition= tu3Ct3;
        grdtu33.Activations.add(new Activation(tu3, "full", TransitionOperation.SendOverNetwork, "OP3"));
        grdtu33.Activations.add(new Activation(tu3, "P_a3", TransitionOperation.Copy, "P_a3"));
        tu3.GuardMappingList.add(grdtu33);

        tu3.Delay = 0;
        pn.Transitions.add(tu3);

        ////// Te3 ------------------------------------------------
        PetriTransition te3 = new PetriTransition(pn);
        te3.TransitionName = "T_e3";
        te3.InputPlaceName.add("P_x3");
        te3.InputPlaceName.add("P_TL3");


        Condition te3Ctu3 = new Condition(te3, "P_TL3", TransitionCondition.Equal,"green");
        Condition te3Cte3 = new Condition(te3, "P_x3", TransitionCondition.HaveCar);
        te3Ctu3.SetNextCondition(LogicConnector.AND, te3Cte3);

        GuardMapping grdte3 = new GuardMapping();
        grdte3.condition= te3Ctu3;
        grdte3.Activations.add(new Activation(te3, "P_x3", TransitionOperation.PopElementWithoutTarget, "P_b3"));
        grdte3.Activations.add(new Activation(te3, "P_TL3", TransitionOperation.Move, "P_TL3"));

        te3.GuardMappingList.add(grdte3);

        te3.Delay = 0;
        pn.Transitions.add(te3);




        //LANE4-----------------------------------------------------------------------------------
        DataCar pa4 = new DataCar();
        pa4.SetName("P_a4");
        pn.PlaceList.add(pa4);

        DataCarQueue px4 = new DataCarQueue();
        px4.Value.Size = 3;
        px4.SetName("P_x4");
        pn.PlaceList.add(px4);

        DataString pTL4 = new DataString();
        pTL4.SetName("P_TL4");
        pn.PlaceList.add(pTL4);

        DataCar pb4 = new DataCar();
        pb4.SetName("P_b4");
        pn.PlaceList.add(pb4);

        DataTransfer OP4 = new DataTransfer();
        OP4.SetName("OP4");
        OP4.Value = new TransferOperation("localhost", "1080", "In");
        pn.PlaceList.add(OP4);



        /////// Tu3 ------------------------------------------------
        PetriTransition tu4 = new PetriTransition(pn);
        tu4.TransitionName = "T_u4";
        tu4.InputPlaceName.add("P_a4");
        tu4.InputPlaceName.add("P_x4");

        Condition tu4Ctu4 = new Condition(tu4, "P_a4", TransitionCondition.NotNull);
        Condition tu4Cte4 = new Condition(tu4, "P_x4", TransitionCondition.CanAddCars);
        tu4Ctu4.SetNextCondition(LogicConnector.AND, tu4Cte4);

        GuardMapping grdtu4 = new GuardMapping();
        grdtu4.condition= tu4Ctu4;
        grdtu4.Activations.add(new Activation(tu4, "P_a4", TransitionOperation.AddElement, "P_x4"));
        tu4.GuardMappingList.add(grdtu4);

        Condition tu4Ct4 = new Condition(tu4, "P_a4", TransitionCondition.NotNull);
        Condition tu4Ct44 = new Condition(tu4, "P_x4", TransitionCondition.CanNotAddCars);
        tu2Ct3.SetNextCondition(LogicConnector.AND, tu2Ct4);

        GuardMapping grdtu44 = new GuardMapping();
        grdtu44.condition= tu4Ct44;
        grdtu44.Activations.add(new Activation(tu4, "full", TransitionOperation.SendOverNetwork, "OP4"));
        grdtu44.Activations.add(new Activation(tu4, "P_a4", TransitionOperation.Copy, "P_a4"));
        tu4.GuardMappingList.add(grdtu44);

        tu4.Delay = 0;
        pn.Transitions.add(tu4);

        ////// Te3 ------------------------------------------------
        PetriTransition te4 = new PetriTransition(pn);
        te4.TransitionName = "T_e4";
        te4.InputPlaceName.add("P_x4");
        te4.InputPlaceName.add("P_TL4");


        Condition te4Ctu4 = new Condition(te4, "P_TL4", TransitionCondition.Equal,"green");
        Condition te4Cte4 = new Condition(te4, "P_x4", TransitionCondition.HaveCar);
        te4Ctu4.SetNextCondition(LogicConnector.AND, te4Cte4);

        GuardMapping grdte4 = new GuardMapping();
        grdte4.condition= te4Ctu4;
        grdte4.Activations.add(new Activation(te4, "P_x4", TransitionOperation.PopElementWithoutTarget, "P_b4"));
        grdte4.Activations.add(new Activation(te4, "P_TL4", TransitionOperation.Move, "P_TL4"));

        te4.GuardMappingList.add(grdte4);

        te4.Delay = 0;
        pn.Transitions.add(te4);
    }
}
