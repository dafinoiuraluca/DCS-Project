package Proiect.Intersectie2;

import Components.*;
import DataObjects.DataCar;
import DataObjects.DataCarQueue;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Intersectie {
    public static void main(String[] args) {
        PetriNet pn1 = new PetriNet();
        pn1.PetriNetName = "Second Petri";
        pn1.NetworkPort = 1082;

        //green
        DataString green = new DataString();
        green.Printable = false;
        green.SetName("green");
        green.SetValue("green");
        pn1.ConstantPlaceList.add(green);

        // full
        DataString full = new DataString();
        full.SetName("full");
        full.SetValue("full");
        pn1.ConstantPlaceList.add(full);


        //==============================================================================================================
        //============================LANE1=============================================================================

        // interior
        DataCar P_ai1 = new DataCar();
        P_ai1.SetName("P_ai1");
        pn1.PlaceList.add(P_ai1);

        DataCarQueue ili1 = new DataCarQueue();
        ili1.SetName("ili1");
        ili1.Value.Size = 2;
        pn1.PlaceList.add(ili1);

        DataCar P_bi1 = new DataCar();
        P_bi1.SetName("P_bi1");
        pn1.PlaceList.add(P_bi1);


        // mijloc
        DataCar P_am1 = new DataCar();
        P_am1.SetName("P_am1");
        pn1.PlaceList.add(P_am1);

        DataCarQueue ilm1 = new DataCarQueue();
        ilm1.SetName("ilm1");
        ilm1.Value.Size = 2;
        pn1.PlaceList.add(ilm1);

        DataCar P_bm1 = new DataCar();
        P_bm1.SetName("P_bm1");
        pn1.PlaceList.add(P_bm1);


        //exterior
        DataCar P_ae1 = new DataCar();
        P_ae1.SetName("P_ae1");
        pn1.PlaceList.add(P_ae1);

        DataCarQueue ile1 = new DataCarQueue();
        ile1.SetName("ile1");
        ile1.Value.Size = 2;
        pn1.PlaceList.add(ile1);

        DataCar P_be1 = new DataCar();
        P_be1.SetName("P_be1");
        pn1.PlaceList.add(P_be1);


        DataTransfer OP1 = new DataTransfer();
        OP1.SetName("OP1");
        OP1.Value = new TransferOperation("localhost", "1082", "in1");
        pn1.PlaceList.add(OP1);

        DataString PTL1 = new DataString();
        PTL1.SetName("P_TL1");
        pn1.PlaceList.add(PTL1);


        //==============================================================================================================
        //============================LANE2=============================================================================
        // interior
        DataCar P_ai2 = new DataCar();
        P_ai2.SetName("P_ai2");
        pn1.PlaceList.add(P_ai2);

        DataCarQueue ili2 = new DataCarQueue();
        ili2.SetName("ili2");
        ili2.Value.Size = 2;
        pn1.PlaceList.add(ili2);

        //mijloc
        DataCar P_am2 = new DataCar();
        P_am2.SetName("P_am2");
        pn1.PlaceList.add(P_am2);

        DataCarQueue ilm2 = new DataCarQueue();
        ilm2.SetName("ilm2");
        ilm2.Value.Size = 2;
        pn1.PlaceList.add(ilm2);


        //exterior
        DataCar P_ae2 = new DataCar();
        P_ae2.SetName("P_ae2");
        pn1.PlaceList.add(P_ae2);

        DataCarQueue ile2 = new DataCarQueue();
        ile2.SetName("ile2");
        ile2.Value.Size = 2;
        pn1.PlaceList.add(ile2);


        DataTransfer OP2 = new DataTransfer();
        OP2.SetName("OP2");
        OP2.Value = new TransferOperation("localhost", "1082", "in2");
        pn1.PlaceList.add(OP2);

        DataString PTL2 = new DataString();
        PTL2.SetName("P_TL2");
        pn1.PlaceList.add(PTL2);



        //==============================================================================================================
        //============================LANE3=============================================================================
        // interior
        DataCar P_ai3 = new DataCar();
        P_ai3.SetName("P_ai3");
        pn1.PlaceList.add(P_ai3);

        DataCarQueue ili3 = new DataCarQueue();
        ili3.SetName("ili3");
        ili3.Value.Size = 2;
        pn1.PlaceList.add(ili3);


        // mijloc
        DataCar P_am3 = new DataCar();
        P_am3.SetName("P_am3");
        pn1.PlaceList.add(P_am3);

        DataCarQueue ilm3 = new DataCarQueue();
        ilm3.SetName("ilm3");
        ilm3.Value.Size = 2;
        pn1.PlaceList.add(ilm3);


        // exterior
        DataCar P_ae3 = new DataCar();
        P_ae3.SetName("P_ae3");
        pn1.PlaceList.add(P_ae3);

        DataCarQueue ile3 = new DataCarQueue();
        ile3.SetName("ile3");
        ile3.Value.Size = 2;
        pn1.PlaceList.add(ile3);


        DataString PTL3 = new DataString();
        PTL3.SetName("P_TL3");
        pn1.PlaceList.add(PTL3);

        DataTransfer OP3 = new DataTransfer();
        OP3.SetName("OP3");
        OP3.Value = new TransferOperation("localhost", "1082", "in1");
        pn1.PlaceList.add(OP3);


        //==============================================================================================================
        //============================LANE4=============================================================================
        // interior
        DataCar P_ai4 = new DataCar();
        P_ai4.SetName("P_ai4");
        pn1.PlaceList.add(P_ai4);

        DataCarQueue ili4 = new DataCarQueue();
        ili4.SetName("ili4");
        ili4.Value.Size = 2;
        pn1.PlaceList.add(ili4);


        // mijloc
        DataCar P_am4 = new DataCar();
        P_am4.SetName("P_am4");
        pn1.PlaceList.add(P_am4);

        DataCarQueue ilm4 = new DataCarQueue();
        ilm4.SetName("ilm4");
        ilm4.Value.Size = 2;
        pn1.PlaceList.add(ilm4);


        // exterior
        DataCar P_ae4 = new DataCar();
        P_ae4.SetName("P_ae4");
        pn1.PlaceList.add(P_ae4);

        DataCarQueue ile4 = new DataCarQueue();
        ile4.SetName("ile4");
        ile4.Value.Size = 2;
        pn1.PlaceList.add(ile4);


        DataTransfer OP4 = new DataTransfer();
        OP4.SetName("OP4");
        OP4.Value = new TransferOperation("localhost", "1082", "in2");
        pn1.PlaceList.add(OP4);

        DataString PTL4 = new DataString();
        PTL4.SetName("P_TL4");
        pn1.PlaceList.add(PTL4);



        // OUTPUTS------------------------------------------------------------------------------------------------------
        DataCar oli1 = new DataCar();
        oli1.SetName("oli1");
        pn1.PlaceList.add(oli1);

        DataCar olm1 = new DataCar();
        olm1.SetName("olm1");
        pn1.PlaceList.add(olm1);

        DataCar ole1 = new DataCar();
        ole1.SetName("ole1");
        pn1.PlaceList.add(ole1);

        DataCar oli2 = new DataCar();
        oli2.SetName("oli2");
        pn1.PlaceList.add(oli2);

        DataCar ole2 = new DataCar();
        ole2.SetName("ole2");
        pn1.PlaceList.add(ole2);

        DataCar oli3 = new DataCar();
        oli3.SetName("oli3");
        pn1.PlaceList.add(oli3);

        DataCar olm3 = new DataCar();
        olm3.SetName("olm3");
        pn1.PlaceList.add(olm3);

        DataCar ole3 = new DataCar();
        ole3.SetName("ole3");
        pn1.PlaceList.add(ole3);

        DataCar oli4 = new DataCar();
        oli4.SetName("oli4");
        pn1.PlaceList.add(oli4);

        DataCar olm4 = new DataCar();
        olm4.SetName("olm4");
        pn1.PlaceList.add(olm4);

        DataCar ole4 = new DataCar();
        ole4.SetName("ole4");
        pn1.PlaceList.add(ole4);


        // Cars intre queues
        DataCar P_ci1 = new DataCar();
        P_ci1.SetName("P_ci1");
        pn1.PlaceList.add(P_ci1);

        DataCar P_di1 = new DataCar();
        P_di1.SetName("P_di1");
        pn1.PlaceList.add(P_di1);

        DataCar P_dm1 = new DataCar();
        P_dm1.SetName("P_dm1");
        pn1.PlaceList.add(P_dm1);

        DataCar P_de1 = new DataCar();
        P_de1.SetName("P_de1");
        pn1.PlaceList.add(P_de1);

        DataCar P_ei1 = new DataCar();
        P_ei1.SetName("P_ei1");
        pn1.PlaceList.add(P_ei1);

        DataCar P_em1 = new DataCar();
        P_em1.SetName("P_em1");
        pn1.PlaceList.add(P_em1);

        DataCar P_ee1 = new DataCar();
        P_ee1.SetName("P_ee1");
        pn1.PlaceList.add(P_ee1);


        // When exiting the intersection
        DataTransfer E_oli3 = new DataTransfer();
        E_oli3.SetName("E_oli3");
        E_oli3.Value = new TransferOperation("localhost", "1084", "E_oli3");
        pn1.PlaceList.add(E_oli3);


        // TRANSITIONS--------------------------------------------------------------------------------------------------

        // PENTRU LANE-URILE DE INPUT

        // INTERIOR
        // T_ai1 - intre P_ai1 - ili1
        PetriTransition tai1 = new PetriTransition(pn1);
        tai1.TransitionName = "T_ai1";
        tai1.InputPlaceName.add("P_ai1");
        tai1.InputPlaceName.add("ili1");

        Condition Tai1Ct1 = new Condition(tai1, "P_ai1", TransitionCondition.NotNull);
        Condition Tai1Ct2 = new Condition(tai1, "ili1", TransitionCondition.CanAddCars);
        Tai1Ct1.SetNextCondition(LogicConnector.AND, Tai1Ct2);

        GuardMapping grdTai1 = new GuardMapping();
        grdTai1.condition = Tai1Ct1;
        grdTai1.Activations.add(new Activation(tai1, "P_ai1", TransitionOperation.AddElement, "ili1"));
        tai1.GuardMappingList.add(grdTai1);


        Condition Tai1Ct3 = new Condition(tai1, "P_ai1", TransitionCondition.NotNull);
        Condition Tai1Ct4 = new Condition(tai1, "ili1", TransitionCondition.CanNotAddCars);
        Tai1Ct3.SetNextCondition(LogicConnector.AND, Tai1Ct4);

        GuardMapping grdTai1_full = new GuardMapping();
        grdTai1_full.condition= Tai1Ct3;
        grdTai1_full.Activations.add(new Activation(tai1, "full", TransitionOperation.SendOverNetwork, "OP1"));
        grdTai1_full.Activations.add(new Activation(tai1, "P_ai1", TransitionOperation.Copy, "P_ai1"));
        tai1.GuardMappingList.add(grdTai1_full);

        tai1.Delay = 0;
        pn1.Transitions.add(tai1);


        // T_bi1 - intre ili1 - P_bi1
        PetriTransition tbi1 = new PetriTransition(pn1);
        tbi1.TransitionName = "T_bi1";
        tbi1.InputPlaceName.add("ili1");
        tbi1.InputPlaceName.add("P_TL1");

        Condition Tbi1Ct1 = new Condition(tbi1, "P_TL1", TransitionCondition.Equal, "green");
        Condition Tbi1Ct2 = new Condition(tbi1, "ili1", TransitionCondition.HaveCar);
        Tbi1Ct1.SetNextCondition(LogicConnector.AND, Tbi1Ct2);

        GuardMapping grdTbi1 = new GuardMapping();
        grdTbi1.condition = Tbi1Ct1;
        grdTbi1.Activations.add(new Activation(tbi1, "ili1", TransitionOperation.PopElementWithoutTarget, "P_bi1"));
        grdTbi1.Activations.add(new Activation(tbi1, "P_TL1", TransitionOperation.Move, "P_TL1"));

        tbi1.GuardMappingList.add(grdTbi1);

        tbi1.Delay = 3;
        pn1.Transitions.add(tbi1);


        // T_ai2 - intre P_ai2 - ili2
        PetriTransition tai2 = new PetriTransition(pn1);
        tai2.TransitionName = "T_ai2";
        tai2.InputPlaceName.add("P_ai2");
        tai2.InputPlaceName.add("ili2");

        Condition Tai2Ct1 = new Condition(tai2, "P_ai2", TransitionCondition.NotNull);
        Condition Tai2Ct2 = new Condition(tai2, "ili2", TransitionCondition.CanAddCars);
        Tai2Ct1.SetNextCondition(LogicConnector.AND, Tai2Ct2);

        GuardMapping grdTai2 = new GuardMapping();
        grdTai2.condition = Tai2Ct1;
        grdTai2.Activations.add(new Activation(tai2, "P_ai2", TransitionOperation.AddElement, "ili2"));
        tai2.GuardMappingList.add(grdTai2);


        Condition Tai2Ct3 = new Condition(tai2, "P_ai2", TransitionCondition.NotNull);
        Condition Tai2Ct4 = new Condition(tai2, "ili2", TransitionCondition.CanNotAddCars);
        Tai2Ct3.SetNextCondition(LogicConnector.AND, Tai2Ct4);

        GuardMapping grdTai2_full = new GuardMapping();
        grdTai2_full.condition= Tai2Ct3;
        grdTai2_full.Activations.add(new Activation(tai2, "full", TransitionOperation.SendOverNetwork, "OP2"));
        grdTai2_full.Activations.add(new Activation(tai2, "P_ai2", TransitionOperation.Copy, "P_ai2"));
        tai2.GuardMappingList.add(grdTai2_full);

        tai2.Delay = 0;
        pn1.Transitions.add(tai2);


        // T_ai3 - intre P_ai3 - ili3
        PetriTransition tai3 = new PetriTransition(pn1);
        tai3.TransitionName = "T_ai3";
        tai3.InputPlaceName.add("P_ai3");
        tai3.InputPlaceName.add("ili3");

        Condition Tai3Ct1 = new Condition(tai3, "P_ai3", TransitionCondition.NotNull);
        Condition Tai3Ct2 = new Condition(tai3, "ili3", TransitionCondition.CanAddCars);
        Tai3Ct1.SetNextCondition(LogicConnector.AND, Tai3Ct2);

        GuardMapping grdTai3 = new GuardMapping();
        grdTai3.condition = Tai3Ct1;
        grdTai3.Activations.add(new Activation(tai3, "P_ai3", TransitionOperation.AddElement, "ili3"));
        tai3.GuardMappingList.add(grdTai3);


        Condition Tai3Ct3 = new Condition(tai3, "P_ai3", TransitionCondition.NotNull);
        Condition Tai3Ct4 = new Condition(tai3, "ili3", TransitionCondition.CanNotAddCars);
        Tai3Ct3.SetNextCondition(LogicConnector.AND, Tai3Ct4);

        GuardMapping grdTai3_full = new GuardMapping();
        grdTai3_full.condition= Tai3Ct3;
        grdTai3_full.Activations.add(new Activation(tai3, "full", TransitionOperation.SendOverNetwork, "OP3"));
        grdTai3_full.Activations.add(new Activation(tai3, "P_ai3", TransitionOperation.Copy, "P_ai3"));
        tai3.GuardMappingList.add(grdTai3_full);

        tai3.Delay = 0;
        pn1.Transitions.add(tai3);


        // T_ai4 - intre P_ai4 - ili4
        PetriTransition tai4 = new PetriTransition(pn1);
        tai4.TransitionName = "T_ai4";
        tai4.InputPlaceName.add("P_ai4");
        tai4.InputPlaceName.add("ili4");

        Condition Tai4Ct1 = new Condition(tai4, "P_ai4", TransitionCondition.NotNull);
        Condition Tai4Ct2 = new Condition(tai4, "ili4", TransitionCondition.CanAddCars);
        Tai4Ct1.SetNextCondition(LogicConnector.AND, Tai4Ct2);

        GuardMapping grdTai4 = new GuardMapping();
        grdTai4.condition = Tai4Ct1;
        grdTai4.Activations.add(new Activation(tai4, "P_ai4", TransitionOperation.AddElement, "ili4"));
        tai4.GuardMappingList.add(grdTai4);


        Condition Tai4Ct3 = new Condition(tai4, "P_ai4", TransitionCondition.NotNull);
        Condition Tai4Ct4 = new Condition(tai4, "ili4", TransitionCondition.CanNotAddCars);
        Tai4Ct3.SetNextCondition(LogicConnector.AND, Tai4Ct4);

        GuardMapping grdTai4_full = new GuardMapping();
        grdTai4_full.condition= Tai4Ct3;
        grdTai4_full.Activations.add(new Activation(tai4, "full", TransitionOperation.SendOverNetwork, "OP4"));
        grdTai4_full.Activations.add(new Activation(tai4, "P_ai4", TransitionOperation.Copy, "P_ai4"));
        tai4.GuardMappingList.add(grdTai4_full);

        tai4.Delay = 0;
        pn1.Transitions.add(tai4);


        // MIJLOC
        // T_am1 - intre P_am1 - ilm1
        PetriTransition tam1 = new PetriTransition(pn1);
        tam1.TransitionName = "T_am1";
        tam1.InputPlaceName.add("P_am1");
        tam1.InputPlaceName.add("ilm1");

        Condition Tam1Ct1 = new Condition(tam1, "P_am1", TransitionCondition.NotNull);
        Condition Tam1Ct2 = new Condition(tam1, "ilm1", TransitionCondition.CanAddCars);
        Tam1Ct1.SetNextCondition(LogicConnector.AND, Tam1Ct2);

        GuardMapping grdTam1 = new GuardMapping();
        grdTam1.condition = Tam1Ct1;
        grdTam1.Activations.add(new Activation(tam1, "P_am1", TransitionOperation.AddElement, "ilm1"));
        tam1.GuardMappingList.add(grdTam1);


        Condition Tam1Ct3 = new Condition(tam1, "P_am1", TransitionCondition.NotNull);
        Condition Tam1Ct4 = new Condition(tam1, "ilm1", TransitionCondition.CanNotAddCars);
        Tam1Ct3.SetNextCondition(LogicConnector.AND, Tam1Ct4);

        GuardMapping grdTam1_full = new GuardMapping();
        grdTam1_full.condition= Tam1Ct3;
        grdTam1_full.Activations.add(new Activation(tam1, "full", TransitionOperation.SendOverNetwork, "OP1"));
        grdTam1_full.Activations.add(new Activation(tam1, "P_am1", TransitionOperation.Copy, "P_am1"));
        tam1.GuardMappingList.add(grdTam1_full);

        tam1.Delay = 0;
        pn1.Transitions.add(tam1);


        // T_bm1 - intre ilm1 - P_bm1
        PetriTransition tbm1 = new PetriTransition(pn1);
        tbm1.TransitionName = "T_bm1";
        tbm1.InputPlaceName.add("ilm1");
        tbm1.InputPlaceName.add("P_TL1");

        Condition Tbm1Ct1 = new Condition(tbm1, "P_TL1", TransitionCondition.Equal, "green");
        Condition Tbm1Ct2 = new Condition(tbm1, "ilm1", TransitionCondition.HaveCar);
        Tbm1Ct1.SetNextCondition(LogicConnector.AND, Tbm1Ct2);

        GuardMapping grdTbm1 = new GuardMapping();
        grdTbm1.condition = Tbm1Ct1;
        grdTbm1.Activations.add(new Activation(tbm1, "ilm1", TransitionOperation.PopElementWithoutTarget, "P_bm1"));
        grdTbm1.Activations.add(new Activation(tbm1, "P_TL1", TransitionOperation.Move, "P_TL1"));

        tbm1.GuardMappingList.add(grdTbm1);

        tbm1.Delay = 3;
        pn1.Transitions.add(tbm1);


        // T_am2 - intre P_am2 - ilm2
        PetriTransition tam2 = new PetriTransition(pn1);
        tam2.TransitionName = "T_am2";
        tam2.InputPlaceName.add("P_am2");
        tam2.InputPlaceName.add("ilm2");

        Condition Tam2Ct1 = new Condition(tam2, "P_am2", TransitionCondition.NotNull);
        Condition Tam2Ct2 = new Condition(tam2, "ilm2", TransitionCondition.CanAddCars);
        Tam2Ct1.SetNextCondition(LogicConnector.AND, Tam2Ct2);

        GuardMapping grdTam2 = new GuardMapping();
        grdTam2.condition = Tam2Ct1;
        grdTam2.Activations.add(new Activation(tam2, "P_am2", TransitionOperation.AddElement, "ilm2"));
        tam2.GuardMappingList.add(grdTam2);


        Condition Tam2Ct3 = new Condition(tam2, "P_am2", TransitionCondition.NotNull);
        Condition Tam2Ct4 = new Condition(tam2, "ilm2", TransitionCondition.CanNotAddCars);
        Tam2Ct3.SetNextCondition(LogicConnector.AND, Tam2Ct4);

        GuardMapping grdTam2_full = new GuardMapping();
        grdTam2_full.condition= Tam2Ct3;
        grdTam2_full.Activations.add(new Activation(tam2, "full", TransitionOperation.SendOverNetwork, "OP2"));
        grdTam2_full.Activations.add(new Activation(tam2, "P_am2", TransitionOperation.Copy, "P_am2"));
        tam2.GuardMappingList.add(grdTam2_full);

        tam2.Delay = 0;
        pn1.Transitions.add(tam2);


        // T_bm2 - intre ilm2 - olm3
        PetriTransition tbm2 = new PetriTransition(pn1);
        tbm2.TransitionName = "T_bm2";
        tbm2.InputPlaceName.add("ilm2");
        tbm2.InputPlaceName.add("P_TL2");

        Condition Tbm2Ct1 = new Condition(tbm2, "P_TL2", TransitionCondition.Equal, "green");
        Condition Tbm2Ct2 = new Condition(tbm2, "ilm2", TransitionCondition.HaveCar);
        Tbm2Ct1.SetNextCondition(LogicConnector.AND, Tbm2Ct2);

        GuardMapping grdTbm2 = new GuardMapping();
        grdTbm2.condition = Tbm2Ct1;
        grdTbm2.Activations.add(new Activation(tbm2, "ilm2", TransitionOperation.PopElementWithTarget, "olm3"));
        grdTbm2.Activations.add(new Activation(tbm2, "P_TL2", TransitionOperation.Move, "P_TL2"));

        tbm2.GuardMappingList.add(grdTbm2);

        tbm2.Delay = 3;
        pn1.Transitions.add(tbm2);


        // T_am3 - intre P_am3 - ilm3
        PetriTransition tam3 = new PetriTransition(pn1);
        tam3.TransitionName = "T_am3";
        tam3.InputPlaceName.add("P_am3");
        tam3.InputPlaceName.add("ilm3");

        Condition Tam3Ct1 = new Condition(tam3, "P_am3", TransitionCondition.NotNull);
        Condition Tam3Ct2 = new Condition(tam3, "ilm3", TransitionCondition.CanAddCars);
        Tam3Ct1.SetNextCondition(LogicConnector.AND, Tam3Ct2);

        GuardMapping grdTam3 = new GuardMapping();
        grdTam3.condition = Tam3Ct1;
        grdTam3.Activations.add(new Activation(tam3, "P_am3", TransitionOperation.AddElement, "ilm3"));
        tam3.GuardMappingList.add(grdTam3);


        Condition Tam3Ct3 = new Condition(tam3, "P_am3", TransitionCondition.NotNull);
        Condition Tam3Ct4 = new Condition(tam3, "ilm3", TransitionCondition.CanNotAddCars);
        Tam3Ct3.SetNextCondition(LogicConnector.AND, Tam3Ct4);

        GuardMapping grdTam3_full = new GuardMapping();
        grdTam3_full.condition= Tam3Ct3;
        grdTam3_full.Activations.add(new Activation(tam3, "full", TransitionOperation.SendOverNetwork, "OP3"));
        grdTam3_full.Activations.add(new Activation(tam3, "P_am3", TransitionOperation.Copy, "P_am3"));
        tam3.GuardMappingList.add(grdTam3_full);

        tam3.Delay = 0;
        pn1.Transitions.add(tam3);



        // T_am4 - intre P_am4 - ilm4
        PetriTransition tam4 = new PetriTransition(pn1);
        tam4.TransitionName = "T_am4";
        tam4.InputPlaceName.add("P_am4");
        tam4.InputPlaceName.add("ilm4");

        Condition Tam4Ct1 = new Condition(tam4, "P_am4", TransitionCondition.NotNull);
        Condition Tam4Ct2 = new Condition(tam4, "ilm4", TransitionCondition.CanAddCars);
        Tam4Ct1.SetNextCondition(LogicConnector.AND, Tam4Ct2);

        GuardMapping grdTam4 = new GuardMapping();
        grdTam4.condition = Tam4Ct1;
        grdTam4.Activations.add(new Activation(tam4, "P_am4", TransitionOperation.AddElement, "ilm4"));
        tam4.GuardMappingList.add(grdTam4);


        Condition Tam4Ct3 = new Condition(tam4, "P_am4", TransitionCondition.NotNull);
        Condition Tam4Ct4 = new Condition(tam4, "ilm4", TransitionCondition.CanNotAddCars);
        Tam4Ct3.SetNextCondition(LogicConnector.AND, Tam4Ct4);

        GuardMapping grdTam4_full = new GuardMapping();
        grdTam4_full.condition= Tam4Ct3;
        grdTam4_full.Activations.add(new Activation(tam4, "full", TransitionOperation.SendOverNetwork, "OP4"));
        grdTam4_full.Activations.add(new Activation(tam4, "P_am4", TransitionOperation.Copy, "P_am4"));
        tam4.GuardMappingList.add(grdTam4_full);

        tam4.Delay = 0;
        pn1.Transitions.add(tam4);



        // EXTERIOR
        // T_ae1 - intre P_ae1 - ile1
        PetriTransition tae1 = new PetriTransition(pn1);
        tae1.TransitionName = "T_ae1";
        tae1.InputPlaceName.add("P_ae1");
        tae1.InputPlaceName.add("ile1");

        Condition Tae1Ct1 = new Condition(tae1, "P_ae1", TransitionCondition.NotNull);
        Condition Tae1Ct2 = new Condition(tae1, "ile1", TransitionCondition.CanAddCars);
        Tae1Ct1.SetNextCondition(LogicConnector.AND, Tae1Ct2);

        GuardMapping grdTae1 = new GuardMapping();
        grdTae1.condition = Tae1Ct1;
        grdTae1.Activations.add(new Activation(tae1, "P_ae1", TransitionOperation.AddElement, "ile1"));
        tae1.GuardMappingList.add(grdTae1);


        Condition Tae1Ct3 = new Condition(tae1, "P_ae1", TransitionCondition.NotNull);
        Condition Tae1Ct4 = new Condition(tae1, "ile1", TransitionCondition.CanNotAddCars);
        Tae1Ct3.SetNextCondition(LogicConnector.AND, Tae1Ct4);

        GuardMapping grdTae1_full = new GuardMapping();
        grdTae1_full.condition= Tae1Ct3;
        grdTae1_full.Activations.add(new Activation(tae1, "full", TransitionOperation.SendOverNetwork, "OP1"));
        grdTae1_full.Activations.add(new Activation(tae1, "P_ae1", TransitionOperation.Copy, "P_ae1"));
        tae1.GuardMappingList.add(grdTae1_full);

        tae1.Delay = 0;
        pn1.Transitions.add(tae1);



        // T_be1 - intre ile1 - P_be1
        PetriTransition tbe1 = new PetriTransition(pn1);
        tbe1.TransitionName = "T_be1";
        tbe1.InputPlaceName.add("ile1");
        tbe1.InputPlaceName.add("P_TL1");

        Condition Tbe1Ct1 = new Condition(tbe1, "P_TL1", TransitionCondition.Equal, "green");
        Condition Tbe1Ct2 = new Condition(tbe1, "ile1", TransitionCondition.HaveCarForMe);
        Tbe1Ct1.SetNextCondition(LogicConnector.AND, Tbe1Ct2);

        GuardMapping grdTbe1 = new GuardMapping();
        grdTbe1.condition = Tbe1Ct1;
        grdTbe1.Activations.add(new Activation(tbe1, "ile1", TransitionOperation.PopElementWithoutTarget, "P_be1"));
        grdTbe1.Activations.add(new Activation(tbe1, "P_TL1", TransitionOperation.Move, "P_TL1"));

        tbe1.GuardMappingList.add(grdTbe1);

        tbe1.Delay = 3;
        pn1.Transitions.add(tbe1);


        // T_ae2 - intre P_ae2 - ile2
        PetriTransition tae2 = new PetriTransition(pn1);
        tae2.TransitionName = "T_ae2";
        tae2.InputPlaceName.add("P_ae2");
        tae2.InputPlaceName.add("ile2");

        Condition Tae2Ct1 = new Condition(tae2, "P_ae2", TransitionCondition.NotNull);
        Condition Tae2Ct2 = new Condition(tae2, "ile2", TransitionCondition.CanAddCars);
        Tae2Ct1.SetNextCondition(LogicConnector.AND, Tae2Ct2);

        GuardMapping grdTae2 = new GuardMapping();
        grdTae2.condition = Tae2Ct1;
        grdTae2.Activations.add(new Activation(tae2, "P_ae2", TransitionOperation.AddElement, "ile2"));
        tae2.GuardMappingList.add(grdTae2);


        Condition Tae2Ct3 = new Condition(tae2, "P_ae2", TransitionCondition.NotNull);
        Condition Tae2Ct4 = new Condition(tae2, "ile2", TransitionCondition.CanNotAddCars);
        Tae2Ct3.SetNextCondition(LogicConnector.AND, Tae2Ct4);

        GuardMapping grdTae2_full = new GuardMapping();
        grdTae2_full.condition= Tae2Ct3;
        grdTae2_full.Activations.add(new Activation(tae2, "full", TransitionOperation.SendOverNetwork, "OP2"));
        grdTae2_full.Activations.add(new Activation(tae2, "P_ae2", TransitionOperation.Copy, "P_ae2"));
        tae2.GuardMappingList.add(grdTae2_full);

        tae2.Delay = 0;
        pn1.Transitions.add(tae2);


        // T_ae3 - intre P_ae3 - ile3
        PetriTransition tae3 = new PetriTransition(pn1);
        tae3.TransitionName = "T_ae3";
        tae3.InputPlaceName.add("P_ae3");
        tae3.InputPlaceName.add("ile3");

        Condition Tae3Ct1 = new Condition(tae3, "P_ae3", TransitionCondition.NotNull);
        Condition Tae3Ct2 = new Condition(tae3, "ile3", TransitionCondition.CanAddCars);
        Tae3Ct1.SetNextCondition(LogicConnector.AND, Tae3Ct2);

        GuardMapping grdTae3 = new GuardMapping();
        grdTae3.condition = Tae3Ct1;
        grdTae3.Activations.add(new Activation(tae3, "P_ae3", TransitionOperation.AddElement, "ile3"));
        tae3.GuardMappingList.add(grdTae3);


        Condition Tae3Ct3 = new Condition(tae3, "P_ae3", TransitionCondition.NotNull);
        Condition Tae3Ct4 = new Condition(tae3, "ile3", TransitionCondition.CanNotAddCars);
        Tae3Ct3.SetNextCondition(LogicConnector.AND, Tae3Ct4);

        GuardMapping grdTae3_full = new GuardMapping();
        grdTae3_full.condition= Tae3Ct3;
        grdTae3_full.Activations.add(new Activation(tae3, "full", TransitionOperation.SendOverNetwork, "OP3"));
        grdTae3_full.Activations.add(new Activation(tae3, "P_ae3", TransitionOperation.Copy, "P_ae3"));
        tae3.GuardMappingList.add(grdTae3_full);

        tae3.Delay = 0;
        pn1.Transitions.add(tae3);



        // T_ae4 - intre P_ae4 - ile4
        PetriTransition tae4 = new PetriTransition(pn1);
        tae4.TransitionName = "T_ae4";
        tae4.InputPlaceName.add("P_ae4");
        tae4.InputPlaceName.add("ile4");

        Condition Tae4Ct1 = new Condition(tae4, "P_ae4", TransitionCondition.NotNull);
        Condition Tae4Ct2 = new Condition(tae4, "ile4", TransitionCondition.CanAddCars);
        Tae4Ct1.SetNextCondition(LogicConnector.AND, Tae4Ct2);

        GuardMapping grdTae4 = new GuardMapping();
        grdTae4.condition = Tae4Ct1;
        grdTae4.Activations.add(new Activation(tae4, "P_ae4", TransitionOperation.AddElement, "ile4"));
        tae4.GuardMappingList.add(grdTae4);


        Condition Tae4Ct3 = new Condition(tae4, "P_ae4", TransitionCondition.NotNull);
        Condition Tae4Ct4 = new Condition(tae4, "ile4", TransitionCondition.CanNotAddCars);
        Tae4Ct3.SetNextCondition(LogicConnector.AND, Tae4Ct4);

        GuardMapping grdTae4_full = new GuardMapping();
        grdTae4_full.condition= Tae4Ct3;
        grdTae4_full.Activations.add(new Activation(tae4, "full", TransitionOperation.SendOverNetwork, "OP4"));
        grdTae4_full.Activations.add(new Activation(tae4, "P_ae4", TransitionOperation.Copy, "P_ae4"));
        tae4.GuardMappingList.add(grdTae4_full);

        tae4.Delay = 0;
        pn1.Transitions.add(tae4);


        // INTRE QUEUES

        // Interior
        // T_ai12 - intre P_bi1 - ili2
        PetriTransition tai12 = new PetriTransition(pn1);
        tai12.TransitionName = "T_ai12";
        tai12.InputPlaceName.add("P_bi1");
        tai12.InputPlaceName.add("ili2");

        Condition Ti12Ct1 = new Condition(tai12, "P_bi1", TransitionCondition.NotNull);
        Condition Ti12Ct2 = new Condition(tai12, "ili2", TransitionCondition.CanAddCars);
        Ti12Ct1.SetNextCondition(LogicConnector.AND, Ti12Ct2);

        GuardMapping grdTi12 = new GuardMapping();
        grdTi12.condition = Ti12Ct1;
        grdTi12.Activations.add(new Activation(tai12, "P_bi1", TransitionOperation.AddElement, "ili2"));
        tai12.GuardMappingList.add(grdTi12);


        Condition Ti12Ct3 = new Condition(tai12, "P_bi1", TransitionCondition.NotNull);
        Condition Ti12Ct4 = new Condition(tai12, "ili2", TransitionCondition.CanNotAddCars);
        Ti12Ct3.SetNextCondition(LogicConnector.AND, Ti12Ct4);

        GuardMapping grdTi12_tfl = new GuardMapping();
        grdTi12_tfl.condition= Ti12Ct3;
        grdTi12_tfl.Activations.add(new Activation(tai12, "full", TransitionOperation.SendOverNetwork, "OP2"));
        grdTi12_tfl.Activations.add(new Activation(tai12, "P_bi1", TransitionOperation.Copy, "P_bi1"));
        tai12.GuardMappingList.add(grdTi12_tfl);

        tai12.Delay = 0;
        pn1.Transitions.add(tai12);


        // T_bi12 - intre ili2 - P_ci1
        PetriTransition tbi12 = new PetriTransition(pn1);
        tbi12.TransitionName = "T_bi12";
        tbi12.InputPlaceName.add("ili2");
        tbi12.InputPlaceName.add("P_TL2");

        Condition Tbi2Ct1 = new Condition(tbi12, "P_TL2", TransitionCondition.Equal, "green");
        Condition Tbi2Ct2 = new Condition(tbi12, "ili2", TransitionCondition.HaveCarForMe);
        Tbi2Ct1.SetNextCondition(LogicConnector.AND, Tbi2Ct2);

        GuardMapping grdTbi2 = new GuardMapping();
        grdTbi2.condition = Tbi2Ct1;
        grdTbi2.Activations.add(new Activation(tbi12, "ili2", TransitionOperation.PopElementWithoutTarget, "P_ci1"));
        grdTbi2.Activations.add(new Activation(tbi12, "P_TL2", TransitionOperation.Move, "P_TL2"));

        tbi12.GuardMappingList.add(grdTbi2);

        tbi12.Delay = 3;
        pn1.Transitions.add(tbi12);


        // T_ai23 - intre P_ci1 - ili3
        PetriTransition tai23 = new PetriTransition(pn1);
        tai23.TransitionName = "T_ai23";
        tai23.InputPlaceName.add("P_ci1");
        tai23.InputPlaceName.add("ili3");

        Condition Ti23Ct1 = new Condition(tai23, "P_ci1", TransitionCondition.NotNull);
        Condition Ti23Ct2 = new Condition(tai23, "ili3", TransitionCondition.CanAddCars);
        Ti23Ct1.SetNextCondition(LogicConnector.AND, Ti23Ct2);

        GuardMapping grdTi23 = new GuardMapping();
        grdTi23.condition = Ti23Ct1;
        grdTi23.Activations.add(new Activation(tai23, "P_ci1", TransitionOperation.AddElement, "ili3"));
        tai23.GuardMappingList.add(grdTi23);


        Condition Ti23Ct3 = new Condition(tai23, "P_ci1", TransitionCondition.NotNull);
        Condition Ti23Ct4 = new Condition(tai23, "ili3", TransitionCondition.CanNotAddCars);
        Ti23Ct3.SetNextCondition(LogicConnector.AND, Ti23Ct4);

        GuardMapping grdTi23_tfl = new GuardMapping();
        grdTi23_tfl.condition= Ti23Ct3;
        grdTi23_tfl.Activations.add(new Activation(tai23, "full", TransitionOperation.SendOverNetwork, "OP3"));
        grdTi23_tfl.Activations.add(new Activation(tai23, "P_ci1", TransitionOperation.Copy, "P_ci1"));
        tai23.GuardMappingList.add(grdTi23_tfl);

        tai23.Delay = 0;
        pn1.Transitions.add(tai23);


        // T_bi23 - intre ili3 - P_di1
        PetriTransition tbi23 = new PetriTransition(pn1);
        tbi23.TransitionName = "T_bi23";
        tbi23.InputPlaceName.add("ili3");
        tbi23.InputPlaceName.add("P_TL3");

        Condition Tbi23Ct1 = new Condition(tbi23, "P_TL3", TransitionCondition.Equal, "green");
        Condition Tbi23Ct2 = new Condition(tbi23, "ili3", TransitionCondition.HaveCarForMe);
        Tbi23Ct1.SetNextCondition(LogicConnector.AND, Tbi23Ct2);

        GuardMapping grdTbi23 = new GuardMapping();
        grdTbi23.condition = Tbi23Ct1;
        grdTbi23.Activations.add(new Activation(tbi23, "ili3", TransitionOperation.PopElementWithoutTarget, "P_di1"));
        grdTbi23.Activations.add(new Activation(tbi23, "P_TL3", TransitionOperation.Move, "P_TL3"));

        tbi23.GuardMappingList.add(grdTbi23);

        tbi23.Delay = 3;
        pn1.Transitions.add(tbi23);


        // T_di14 - intre P_di1 - ili4
        PetriTransition tdi14 = new PetriTransition(pn1);
        tdi14.TransitionName = "T_di14";
        tdi14.InputPlaceName.add("P_di1");
        tdi14.InputPlaceName.add("ili4");

        Condition Ti34Ct1 = new Condition(tdi14, "P_di1", TransitionCondition.NotNull);
        Condition Ti34Ct2 = new Condition(tdi14, "ili4", TransitionCondition.CanAddCars);
        Ti34Ct1.SetNextCondition(LogicConnector.AND, Ti34Ct2);

        GuardMapping grdTi34 = new GuardMapping();
        grdTi34.condition = Ti34Ct1;
        grdTi34.Activations.add(new Activation(tdi14, "P_di1", TransitionOperation.AddElement, "ili4"));
        tdi14.GuardMappingList.add(grdTi34);


        Condition Ti34Ct3 = new Condition(tdi14, "P_di1", TransitionCondition.NotNull);
        Condition Ti34Ct4 = new Condition(tdi14, "ili4", TransitionCondition.CanNotAddCars);
        Ti34Ct3.SetNextCondition(LogicConnector.AND, Ti34Ct4);

        GuardMapping grdTi34_tfl = new GuardMapping();
        grdTi34_tfl.condition= Ti34Ct3;
        grdTi34_tfl.Activations.add(new Activation(tdi14, "full", TransitionOperation.SendOverNetwork, "OP4"));
        grdTi34_tfl.Activations.add(new Activation(tdi14, "P_di1", TransitionOperation.Copy, "P_di1"));
        tdi14.GuardMappingList.add(grdTi34_tfl);

        tdi14.Delay = 0;
        pn1.Transitions.add(tdi14);


        // T_ei14 - intre ili4 - P_ei1
        PetriTransition tei14 = new PetriTransition(pn1);
        tei14.TransitionName = "T_ei14";
        tei14.InputPlaceName.add("ili4");
        tei14.InputPlaceName.add("P_TL4");

        Condition Tei14Ct1 = new Condition(tei14, "P_TL4", TransitionCondition.Equal, "green");
        Condition Tei14Ct2 = new Condition(tei14, "ili4", TransitionCondition.HaveCarForMe);
        Tei14Ct1.SetNextCondition(LogicConnector.AND, Tei14Ct2);

        GuardMapping grdTei14 = new GuardMapping();
        grdTei14.condition = Tei14Ct1;
        grdTei14.Activations.add(new Activation(tei14, "ili4", TransitionOperation.PopElementWithoutTarget, "P_ei1"));
        grdTei14.Activations.add(new Activation(tei14, "P_TL4", TransitionOperation.Move, "P_TL4"));
        tei14.GuardMappingList.add(grdTei14);

        tei14.Delay = 3;
        pn1.Transitions.add(tei14);


        // T_ei1 = intre P_ei1 - ili1
        PetriTransition tei1 = new PetriTransition(pn1);
        tei1.TransitionName = "T_ei1";
        tei1.InputPlaceName.add("P_ei1");
        tei1.InputPlaceName.add("ili1");

        Condition Tei1Ct1 = new Condition(tei1, "P_ei1", TransitionCondition.NotNull);
        Condition Tei1Ct2 = new Condition(tei1, "ili1", TransitionCondition.CanAddCars);
        Tei1Ct1.SetNextCondition(LogicConnector.AND, Tei1Ct2);

        GuardMapping grdTei1 = new GuardMapping();
        grdTei1.condition = Tei1Ct1;
        grdTei1.Activations.add(new Activation(tei1, "P_ei1", TransitionOperation.AddElement, "ili1"));
        tei1.GuardMappingList.add(grdTei1);


        Condition Tei1Ct3 = new Condition(tei1, "P_ei1", TransitionCondition.NotNull);
        Condition Tei1Ct4 = new Condition(tei1, "ili1", TransitionCondition.CanNotAddCars);
        Tei1Ct3.SetNextCondition(LogicConnector.AND, Tei1Ct4);

        GuardMapping grdTei1_full = new GuardMapping();
        grdTei1_full.condition= Tei1Ct3;
        grdTei1_full.Activations.add(new Activation(tei1, "full", TransitionOperation.SendOverNetwork, "OP3"));
        grdTei1_full.Activations.add(new Activation(tei1, "P_ei1", TransitionOperation.Copy, "P_ei1"));
        tei1.GuardMappingList.add(grdTei1_full);

        tei1.Delay = 0;
        pn1.Transitions.add(tei1);


        // Mijloc
        // T_am12 - intre P_bm1 - ilm2
        PetriTransition tam12 = new PetriTransition(pn1);
        tam12.TransitionName = "T_am12";
        tam12.InputPlaceName.add("P_bm1");
        tam12.InputPlaceName.add("ilm2");

        Condition Tm12Ct1 = new Condition(tam12, "P_bm1", TransitionCondition.NotNull);
        Condition Tm12Ct2 = new Condition(tam12, "ilm2", TransitionCondition.CanAddCars);
        Tm12Ct1.SetNextCondition(LogicConnector.AND, Tm12Ct2);

        GuardMapping grdTm12 = new GuardMapping();
        grdTm12.condition = Tm12Ct1;
        grdTm12.Activations.add(new Activation(tam12, "P_bm1", TransitionOperation.AddElement, "ilm2"));
        tam12.GuardMappingList.add(grdTm12);


        Condition Tm12Ct3 = new Condition(tam12, "P_bm1", TransitionCondition.NotNull);
        Condition Tm12Ct4 = new Condition(tam12, "ilm2", TransitionCondition.CanNotAddCars);
        Tm12Ct3.SetNextCondition(LogicConnector.AND, Tm12Ct4);

        GuardMapping grdTm12_tfl = new GuardMapping();
        grdTm12_tfl.condition= Tm12Ct3;
        grdTm12_tfl.Activations.add(new Activation(tam12, "full", TransitionOperation.SendOverNetwork, "OP2"));
        grdTm12_tfl.Activations.add(new Activation(tam12, "P_bm1", TransitionOperation.Copy, "P_bm1"));
        tam12.GuardMappingList.add(grdTm12_tfl);

        tam12.Delay = 0;
        pn1.Transitions.add(tam12);


        // T_bm23 - intre ilm3 - P_dm1
        PetriTransition tbm23 = new PetriTransition(pn1);
        tbm23.TransitionName = "T_bm23";
        tbm23.InputPlaceName.add("ilm3");
        tbm23.InputPlaceName.add("P_TL3");

        Condition Tbm23Ct1 = new Condition(tbm23, "P_TL3", TransitionCondition.Equal, "green");
        Condition Tbm23Ct2 = new Condition(tbm23, "ilm3", TransitionCondition.HaveCarForMe);
        Tbm23Ct1.SetNextCondition(LogicConnector.AND, Tbm23Ct2);

        GuardMapping grdTbm23 = new GuardMapping();
        grdTbm23.condition = Tbm23Ct1;
        grdTbm23.Activations.add(new Activation(tbm23, "ilm3", TransitionOperation.PopElementWithoutTarget, "P_dm1"));
        grdTbm23.Activations.add(new Activation(tbm23, "P_TL3", TransitionOperation.Move, "P_TL3"));

        tbm23.GuardMappingList.add(grdTbm23);

        tbm23.Delay = 3;
        pn1.Transitions.add(tbm23);


        // T_dm14 - intre P_dm1 - ilm4
        PetriTransition tdm14 = new PetriTransition(pn1);
        tdm14.TransitionName = "T_dm14";
        tdm14.InputPlaceName.add("P_dm1");
        tdm14.InputPlaceName.add("ilm4");

        Condition Tdm14Ct1 = new Condition(tdm14, "P_dm1", TransitionCondition.NotNull);
        Condition Tdm14Ct2 = new Condition(tdm14, "ilm4", TransitionCondition.CanAddCars);
        Tdm14Ct1.SetNextCondition(LogicConnector.AND, Tdm14Ct2);

        GuardMapping grdTdm14 = new GuardMapping();
        grdTdm14.condition = Tdm14Ct1;
        grdTdm14.Activations.add(new Activation(tdm14, "P_dm1", TransitionOperation.AddElement, "ilm4"));
        tdm14.GuardMappingList.add(grdTdm14);


        Condition Tdm14Ct3 = new Condition(tdm14, "P_dm1", TransitionCondition.NotNull);
        Condition Tdm14Ct4 = new Condition(tdm14, "ilm4", TransitionCondition.CanNotAddCars);
        Tdm14Ct3.SetNextCondition(LogicConnector.AND, Tdm14Ct4);

        GuardMapping grdTdm14_tfl = new GuardMapping();
        grdTdm14_tfl.condition= Tdm14Ct3;
        grdTdm14_tfl.Activations.add(new Activation(tdm14, "full", TransitionOperation.SendOverNetwork, "OP4"));
        grdTdm14_tfl.Activations.add(new Activation(tdm14, "P_dm1", TransitionOperation.Copy, "P_dm1"));
        tdm14.GuardMappingList.add(grdTdm14_tfl);

        tdm14.Delay = 0;
        pn1.Transitions.add(tdm14);


        // T_em14 - intre ilm4 - P_em1
        PetriTransition tem14 = new PetriTransition(pn1);
        tem14.TransitionName = "T_em14";
        tem14.InputPlaceName.add("ilm4");
        tem14.InputPlaceName.add("P_TL4");

        Condition Tem14Ct1 = new Condition(tem14, "P_TL4", TransitionCondition.Equal, "green");
        Condition Tem14Ct2 = new Condition(tem14, "ilm4", TransitionCondition.HaveCarForMe);
        Tem14Ct1.SetNextCondition(LogicConnector.AND, Tem14Ct2);

        GuardMapping grdTem14 = new GuardMapping();
        grdTem14.condition = Tem14Ct1;
        grdTem14.Activations.add(new Activation(tem14, "ilm4", TransitionOperation.PopElementWithoutTarget, "P_em1"));
        grdTem14.Activations.add(new Activation(tem14, "P_TL4", TransitionOperation.Move, "P_TL4"));

        tem14.GuardMappingList.add(grdTem14);

        tem14.Delay = 3;
        pn1.Transitions.add(tem14);


        // EXTERIOR
        // T_ae12 - intre P_be1 - ile2
        PetriTransition tae12 = new PetriTransition(pn1);
        tae12.TransitionName = "T_ae12";
        tae12.InputPlaceName.add("P_be1");
        tae12.InputPlaceName.add("ile2");

        Condition Te12Ct1 = new Condition(tae12, "P_be1", TransitionCondition.NotNull);
        Condition Te12Ct2 = new Condition(tae12, "ile2", TransitionCondition.CanAddCars);
        Te12Ct1.SetNextCondition(LogicConnector.AND, Te12Ct2);

        GuardMapping grdTe12 = new GuardMapping();
        grdTe12.condition = Te12Ct1;
        grdTe12.Activations.add(new Activation(tae12, "P_be1", TransitionOperation.AddElement, "ile2"));
        tae12.GuardMappingList.add(grdTe12);


        Condition Te12Ct3 = new Condition(tae12, "P_be1", TransitionCondition.NotNull);
        Condition Te12Ct4 = new Condition(tae12, "ile2", TransitionCondition.CanNotAddCars);
        Te12Ct3.SetNextCondition(LogicConnector.AND, Te12Ct4);

        GuardMapping grdTe12_tfl = new GuardMapping();
        grdTe12_tfl.condition= Te12Ct3;
        grdTe12_tfl.Activations.add(new Activation(tae12, "full", TransitionOperation.SendOverNetwork, "OP2"));
        grdTe12_tfl.Activations.add(new Activation(tae12, "P_be1", TransitionOperation.Copy, "P_be1"));
        tae12.GuardMappingList.add(grdTe12_tfl);

        tae12.Delay = 0;
        pn1.Transitions.add(tae12);


        // T_be23 - intre ile3 - P_de1
        PetriTransition tbe23 = new PetriTransition(pn1);
        tbe23.TransitionName = "T_be23";
        tbe23.InputPlaceName.add("ile3");
        tbe23.InputPlaceName.add("P_TL3");

        Condition Tbe23Ct1 = new Condition(tbe23, "P_TL3", TransitionCondition.Equal, "green");
        Condition Tbe23Ct2 = new Condition(tbe23, "ile3", TransitionCondition.HaveCarForMe);
        Tbe23Ct1.SetNextCondition(LogicConnector.AND, Tbe23Ct2);

        GuardMapping grdTbe23 = new GuardMapping();
        grdTbe23.condition = Tbe23Ct1;
        grdTbe23.Activations.add(new Activation(tbe23, "ile3", TransitionOperation.PopElementWithTarget, "P_de1"));
        grdTbe23.Activations.add(new Activation(tbe23, "P_TL3", TransitionOperation.Move, "P_TL3"));

        tbe23.GuardMappingList.add(grdTbe23);

        tbe23.Delay = 3;
        pn1.Transitions.add(tbe23);


        // T_de14 - intre P_de1 - ile4
        PetriTransition tde14 = new PetriTransition(pn1);
        tde14.TransitionName = "T_de14";
        tde14.InputPlaceName.add("P_de1");
        tde14.InputPlaceName.add("ile4");

        Condition Tde14Ct1 = new Condition(tde14, "P_de1", TransitionCondition.NotNull);
        Condition Tde14Ct2 = new Condition(tde14, "ile4", TransitionCondition.CanAddCars);
        Tde14Ct1.SetNextCondition(LogicConnector.AND, Tde14Ct2);

        GuardMapping grdTde14 = new GuardMapping();
        grdTde14.condition = Tde14Ct1;
        grdTde14.Activations.add(new Activation(tde14, "P_de1", TransitionOperation.AddElement, "ile4"));
        tde14.GuardMappingList.add(grdTde14);


        Condition Tde14Ct3 = new Condition(tde14, "P_de1", TransitionCondition.NotNull);
        Condition Tde14Ct4 = new Condition(tde14, "ile4", TransitionCondition.CanNotAddCars);
        Tde14Ct3.SetNextCondition(LogicConnector.AND, Tde14Ct4);

        GuardMapping grdTde14_tfl = new GuardMapping();
        grdTde14_tfl.condition= Tde14Ct3;
        grdTde14_tfl.Activations.add(new Activation(tde14, "full", TransitionOperation.SendOverNetwork, "OP4"));
        grdTde14_tfl.Activations.add(new Activation(tde14, "P_de1", TransitionOperation.Copy, "P_de1"));
        tde14.GuardMappingList.add(grdTde14_tfl);

        tde14.Delay = 0;
        pn1.Transitions.add(tde14);


        // T_ee14 - intre ile4 - P_ee1
        PetriTransition tee14 = new PetriTransition(pn1);
        tee14.TransitionName = "T_ee14";
        tee14.InputPlaceName.add("ile4");
        tee14.InputPlaceName.add("P_TL4");

        Condition Tee14Ct1 = new Condition(tee14, "P_TL4", TransitionCondition.Equal, "green");
        Condition Tee14Ct2 = new Condition(tee14, "ile4", TransitionCondition.HaveCarForMe);
        Tee14Ct1.SetNextCondition(LogicConnector.AND, Tee14Ct2);

        GuardMapping grdTee14 = new GuardMapping();
        grdTee14.condition = Tee14Ct1;
        grdTee14.Activations.add(new Activation(tee14, "ile4", TransitionOperation.PopElementWithTarget, "P_ee1"));
        grdTee14.Activations.add(new Activation(tee14, "P_TL4", TransitionOperation.Move, "P_TL4"));
        tee14.GuardMappingList.add(grdTee14);

        tee14.Delay = 3;
        pn1.Transitions.add(tee14);



        // OUTPUT TRANSITIONS
        // Toe42 - intre ile1 - ole1
        PetriTransition toe42 = new PetriTransition(pn1);
        toe42.TransitionName = "Toe42";
        toe42.InputPlaceName.add("ile1");

        Condition Toe42Ct1 = new Condition(toe42, "P_TL1", TransitionCondition.Equal, "green");
        Condition Toe42Ct2 = new Condition(toe42, "ile1", TransitionCondition.HaveCarForMe);
        Toe42Ct1.SetNextCondition(LogicConnector.AND, Toe42Ct2);

        GuardMapping grdToe42 = new GuardMapping();
        grdToe42.condition= Toe42Ct1;
        grdToe42.Activations.add(new Activation(toe42, "ile1", TransitionOperation.PopElementWithTarget, "ole1"));
        grdToe42.Activations.add(new Activation(toe42, "P_TL1", TransitionOperation.Move, "P_TL1"));
        toe42.GuardMappingList.add(grdToe42);

        pn1.Transitions.add(toe42);

        // Toe23 - intre ile2 - ole3
        PetriTransition toe23 = new PetriTransition(pn1);
        toe23.TransitionName = "Toe23";
        toe23.InputPlaceName.add("ile2");
        toe23.InputPlaceName.add("P_TL2");

        Condition Tbe12Ct1 = new Condition(toe23, "P_TL2", TransitionCondition.Equal, "green");
        Condition Tbe12Ct2 = new Condition(toe23, "ile2", TransitionCondition.HaveCarForMe);
        Tbe12Ct1.SetNextCondition(LogicConnector.AND, Tbe12Ct2);

        GuardMapping grdTbe12 = new GuardMapping();
        grdTbe12.condition = Tbe12Ct1;
        grdTbe12.Activations.add(new Activation(toe23, "ile2", TransitionOperation.PopElementWithoutTarget, "ole3"));
        grdTbe12.Activations.add(new Activation(toe23, "P_TL2", TransitionOperation.Move, "P_TL2"));

        toe23.GuardMappingList.add(grdTbe12);

        toe23.Delay = 3;
        pn1.Transitions.add(toe23);

        // Toe13 - intre ile1 - ole2
        PetriTransition toe13 = new PetriTransition(pn1);
        toe13.TransitionName = "Toe13";
        toe13.InputPlaceName.add("ile1");

        Condition Toe13Ct1 = new Condition(toe13, "P_TL1", TransitionCondition.Equal, "green");
        Condition Toe13Ct2 = new Condition(toe13, "ile1", TransitionCondition.HaveCarForMe);
        Toe13Ct1.SetNextCondition(LogicConnector.AND, Toe13Ct2);

        GuardMapping grdToe13 = new GuardMapping();
        grdToe13.condition = Toe13Ct1;
        grdToe13.Activations.add(new Activation(toe13, "ile1", TransitionOperation.PopElementWithoutTarget, "ole2"));
        grdToe13.Activations.add(new Activation(toe13, "P_TL1", TransitionOperation.Move, "P_TL1"));
        toe13.GuardMappingList.add(grdToe13);

        pn1.Transitions.add(toe13);


        // Toi23 - intre ili2 - oli3
        PetriTransition toi23 = new PetriTransition(pn1);
        toi23.TransitionName = "Toi23";
        toi23.InputPlaceName.add("ili2");

        Condition Toi23Ct1 = new Condition(toi23, "P_TL2", TransitionCondition.Equal, "green");
        Condition Toi23Ct2 = new Condition(toi23, "ili2", TransitionCondition.HaveCarForMe);
        Toi23Ct1.SetNextCondition(LogicConnector.AND, Toi23Ct2);

        GuardMapping grdToi23 = new GuardMapping();
        grdToi23.condition= Toi23Ct1;
        grdToi23.Activations.add(new Activation(toi23, "ili2", TransitionOperation.PopElementWithoutTarget, "oli3"));
        grdToi23.Activations.add(new Activation(toi23, "P_TL2", TransitionOperation.Move, "P_TL2"));
        toi23.GuardMappingList.add(grdToi23);

        pn1.Transitions.add(toi23);


        // Tom23 - intre ilm2 - olm3
        PetriTransition tom23 = new PetriTransition(pn1);
        tom23.TransitionName = "Tom23";
        tom23.InputPlaceName.add("ilm2");

        Condition Tom23Ct1 = new Condition(toe13, "P_TL2", TransitionCondition.Equal, "green");
        Condition Tom23Ct2 = new Condition(tom23, "ilm2", TransitionCondition.HaveCarForMe);
        Tom23Ct1.SetNextCondition(LogicConnector.AND, Tom23Ct2);

        GuardMapping grdTom23 = new GuardMapping();
        grdTom23.condition= Tom23Ct1;
        grdTom23.Activations.add(new Activation(tom23, "ilm2", TransitionOperation.PopElementWithoutTarget, "olm3"));
        grdTom23.Activations.add(new Activation(tom23, "P_TL2", TransitionOperation.Move, "P_TL2"));
        tom23.GuardMappingList.add(grdTom23);

        pn1.Transitions.add(tom23);


        // Toe22 - intre ile2 - oli2
        PetriTransition toe22 = new PetriTransition(pn1);
        toe22.TransitionName = "Toe22";
        toe22.InputPlaceName.add("ile2");

        Condition Toe22Ct1 = new Condition(toe22, "P_TL2", TransitionCondition.Equal, "green");
        Condition Toe22Ct2 = new Condition(toe22, "ile2", TransitionCondition.HaveCarForMe);
        Toe22Ct1.SetNextCondition(LogicConnector.AND, Toe22Ct2);

        GuardMapping grdToe22 = new GuardMapping();
        grdToe22.condition= Toe22Ct1;
        grdToe22.Activations.add(new Activation(toe22, "ile2", TransitionOperation.PopElementWithoutTarget, "oli2"));
        grdToe22.Activations.add(new Activation(toe22, "P_TL2", TransitionOperation.Move, "P_TL2"));
        toe22.GuardMappingList.add(grdToe22);

        pn1.Transitions.add(toe22);


        // Toe33 - intre ile3 - ole3
        PetriTransition te33 = new PetriTransition(pn1);
        te33.TransitionName = "Toe33";
        te33.InputPlaceName.add("ile3");

        Condition Toe33Ct1 = new Condition(toe22, "P_TL3", TransitionCondition.Equal, "green");
        Condition Te33Ct2 = new Condition(te33, "ile3", TransitionCondition.HaveCarForMe);
        Toe33Ct1.SetNextCondition(LogicConnector.AND, Te33Ct2);

        GuardMapping grdTe33 = new GuardMapping();
        grdTe33.condition= Toe33Ct1;
        grdTe33.Activations.add(new Activation(te33, "ile3", TransitionOperation.PopElementWithoutTarget, "ole3"));
        grdTe33.Activations.add(new Activation(te33, "P_TL3", TransitionOperation.Move, "P_TL3"));
        te33.GuardMappingList.add(grdTe33);

        pn1.Transitions.add(te33);


        // Toe44 - intre ile4 - ole4
        PetriTransition toe44 = new PetriTransition(pn1);
        toe44.TransitionName = "Toe44";
        toe44.InputPlaceName.add("ile4");

        Condition Toe44Ct1 = new Condition(toe22, "P_TL4", TransitionCondition.Equal, "green");
        Condition Toe44Ct2 = new Condition(toe44, "ile4", TransitionCondition.HaveCarForMe);
        Toe44Ct1.SetNextCondition(LogicConnector.AND, Toe44Ct2);

        GuardMapping grdToe44 = new GuardMapping();
        grdToe44.condition= Toe44Ct1;
        grdToe44.Activations.add(new Activation(toe44, "ile4", TransitionOperation.PopElementWithoutTarget, "ole4"));
        grdTe33.Activations.add(new Activation(toe44, "P_TL4", TransitionOperation.Move, "P_TL4"));
        toe44.GuardMappingList.add(grdToe44);

        pn1.Transitions.add(toe44);


        // Toi34 - intre ili3 - oli4
        PetriTransition toi34 = new PetriTransition(pn1);
        toi34.TransitionName = "Toi34";
        toi34.InputPlaceName.add("ili3");

        Condition Toi34Ct1 = new Condition(toi34, "P_TL3", TransitionCondition.Equal, "green");
        Condition Toi34Ct2 = new Condition(toi34, "ili3", TransitionCondition.HaveCarForMe);
        Toi34Ct1.SetNextCondition(LogicConnector.AND, Toi34Ct2);

        GuardMapping grdToi34 = new GuardMapping();
        grdToi34.condition= Toi34Ct1;
        grdToi34.Activations.add(new Activation(toi34, "ili3", TransitionOperation.PopElementWithoutTarget, "oli4"));
        grdToi34.Activations.add(new Activation(toi34, "P_TL3", TransitionOperation.Move, "P_TL3"));
        toi34.GuardMappingList.add(grdToi34);

        pn1.Transitions.add(toi34);


        // Tom34 - intre ilm3 - olm4
        PetriTransition tom34 = new PetriTransition(pn1);
        tom34.TransitionName = "Tom34";
        tom34.InputPlaceName.add("ilm3");

        Condition Tom34Ct1 = new Condition(tom34, "P_TL3", TransitionCondition.Equal, "green");
        Condition Tom34Ct2 = new Condition(tom34, "ilm3", TransitionCondition.HaveCarForMe);
        Tom34Ct1.SetNextCondition(LogicConnector.AND, Tom34Ct2);

        GuardMapping grdTom34 = new GuardMapping();
        grdTom34.condition= Tom34Ct1;
        grdTom34.Activations.add(new Activation(tom34, "ilm3", TransitionOperation.PopElementWithoutTarget, "olm4"));
        grdTom34.Activations.add(new Activation(tom34, "P_TL3", TransitionOperation.Move, "P_TL3"));
        tom34.GuardMappingList.add(grdTom34);

        pn1.Transitions.add(tom34);


        // Toe34 - intre ile3 - ole4
        PetriTransition toe34 = new PetriTransition(pn1);
        toe34.TransitionName = "Toe34";
        toe34.InputPlaceName.add("ile3");

        Condition Toe34Ct1 = new Condition(tom34, "P_TL3", TransitionCondition.Equal, "green");
        Condition Toe34Ct2 = new Condition(toe34, "ile3", TransitionCondition.HaveCarForMe);
        Toe34Ct1.SetNextCondition(LogicConnector.AND, Toe34Ct2);

        GuardMapping grdToe34 = new GuardMapping();
        grdToe34.condition= Toe34Ct1;
        grdToe34.Activations.add(new Activation(toe34, "ile3", TransitionOperation.PopElementWithoutTarget, "ole4"));
        grdToe34.Activations.add(new Activation(toe34, "P_TL3", TransitionOperation.Move, "P_TL3"));
        toe34.GuardMappingList.add(grdToe34);

        pn1.Transitions.add(toe34);


        // Toi41 - intre ili4 - oli1
        PetriTransition toi41 = new PetriTransition(pn1);
        toi41.TransitionName = "Toi41";
        toi41.InputPlaceName.add("ili4");

        Condition Toi41Ct1 = new Condition(toi41, "P_TL4", TransitionCondition.Equal, "green");
        Condition Toi41Ct2 = new Condition(toi41, "ili4", TransitionCondition.HaveCarForMe);
        Toi41Ct1.SetNextCondition(LogicConnector.AND, Toi41Ct2);

        GuardMapping grdToi41 = new GuardMapping();
        grdToi41.condition = Toi41Ct1;
        grdToi41.Activations.add(new Activation(toi41, "ili4", TransitionOperation.PopElementWithoutTarget, "oli1"));
        grdToi41.Activations.add(new Activation(toi41, "P_TL4", TransitionOperation.Move, "P_TL4"));
        toi41.GuardMappingList.add(grdToi41);

        pn1.Transitions.add(toi41);


        // Tom41 - intre ilm4 - olm1
        PetriTransition tom41 = new PetriTransition(pn1);
        tom41.TransitionName = "Tom41";
        tom41.InputPlaceName.add("ilm4");

        Condition Tom41Ct1 = new Condition(tom41, "P_TL4", TransitionCondition.Equal, "green");
        Condition Tom41Ct2 = new Condition(tom41, "ilm4", TransitionCondition.HaveCarForMe);
        Tom41Ct1.SetNextCondition(LogicConnector.AND, Tom41Ct2);

        GuardMapping grdTom41 = new GuardMapping();
        grdTom41.condition= Tom41Ct1;
        grdTom41.Activations.add(new Activation(tom41, "ilm4", TransitionOperation.PopElementWithoutTarget, "olm1"));
        grdTom41.Activations.add(new Activation(tom41, "P_TL4", TransitionOperation.Move, "P_TL4"));
        tom41.GuardMappingList.add(grdTom41);

        pn1.Transitions.add(tom41);


        // Toe41 - intre ile4 - ole1
        PetriTransition toe41 = new PetriTransition(pn1);
        toe41.TransitionName = "Toe41";
        toe41.InputPlaceName.add("ile4");

        Condition Toe41Ct1 = new Condition(toe41, "P_TL4", TransitionCondition.Equal, "green");
        Condition Toe41Ct2 = new Condition(toe41, "ile4", TransitionCondition.HaveCarForMe);
        Toe41Ct1.SetNextCondition(LogicConnector.AND, Toe41Ct2);

        GuardMapping grdToe41 = new GuardMapping();
        grdToe41.condition= Toe41Ct1;
        grdToe41.Activations.add(new Activation(toe41, "ile4", TransitionOperation.PopElementWithoutTarget, "ole1"));
        grdToe41.Activations.add(new Activation(toe41, "P_TL4", TransitionOperation.Move, "P_TL4"));
        toe41.GuardMappingList.add(grdToe41);

        pn1.Transitions.add(toe41);



        // For middle street
        // T_oli3
        PetriTransition toli3 = new PetriTransition(pn1);
        toli3.TransitionName = "T_oli3";
        toli3.InputPlaceName.add("oli3");

        Condition Toli3Ct1 = new Condition(toli3, "oli3", TransitionCondition.NotNull);

        GuardMapping grdToli3 = new GuardMapping();
        grdToli3.condition = Toli3Ct1;
        grdToli3.Activations.add(new Activation(toli3, "oli3", TransitionOperation.SendOverNetwork, "E_oli3"));
        toli3.GuardMappingList.add(grdToli3);

        toli3.Delay = 0;
        pn1.Transitions.add(toli3);




        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn1;
        frame.setVisible(true);

        System.out.println("Intersectie2 started \n ------------------------------");
        pn1.Delay = 2000;
        pn1.Start();
    }
}
