package Proiect.Intersectie1;

import Components.*;
import DataObjects.DataCar;
import DataObjects.DataCarQueue;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Plant {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Round About";
        pn.NetworkPort = 1081;

        // INPUT PLACES-------------------------------------------------------------------------------------------------

        // Strada Carpati
        DataCar i1 = new DataCar();
        i1.SetName("i1");
        pn.PlaceList.add(i1);

        DataCar e1 = new DataCar();
        e1.SetName("e1");
        pn.PlaceList.add(e1);

        // Bd. Dacia dreapta
        DataCar i2 = new DataCar();
        i2.SetName("i2");
        pn.PlaceList.add(i2);

        DataCar e2 = new DataCar();
        e2.SetName("e2");
        pn.PlaceList.add(e2);

        // Bd. Dacia stanga
        DataCar i3 = new DataCar();
        i3.SetName("i3");
        pn.PlaceList.add(i3);

        DataCar e3 = new DataCar();
        e3.SetName("e3");
        pn.PlaceList.add(e3);

        // OUTPUT PLACES------------------------------------------------------------------------------------------------
        DataCar oli1 = new DataCar();
        oli1.SetName("oli1");
        pn.PlaceList.add(oli1);

        DataCar ole1 = new DataCar();
        ole1.SetName("ole1");
        pn.PlaceList.add(ole1);

        // Bd. Dacia dreapta
        DataCar oli2 = new DataCar();
        oli2.SetName("oli2");
        pn.PlaceList.add(oli2);

        DataCar ole2 = new DataCar();
        ole2.SetName("ole2");
        pn.PlaceList.add(ole2);

        // Bd. Dacia stanga
        DataCar oli3 = new DataCar();
        oli3.SetName("oli3");
        pn.PlaceList.add(oli3);

        DataCar ole3 = new DataCar();
        ole3.SetName("ole3");
        pn.PlaceList.add(ole3);

        // CAR LANES----------------------------------------------------------------------------------------------------
        DataCarQueue ili1 = new DataCarQueue();
        ili1.SetName("ili1");
        ili1.Value.Size = 2;
        pn.PlaceList.add(ili1);

        DataCarQueue ile1 = new DataCarQueue();
        ile1.SetName("ile1");
        ile1.Value.Size = 2;
        pn.PlaceList.add(ile1);

        DataCarQueue ili2 = new DataCarQueue();
        ili2.SetName("ili2");
        ili2.Value.Size = 2;
        pn.PlaceList.add(ili2);

        DataCarQueue ile2 = new DataCarQueue();
        ile2.SetName("ile2");
        ile2.Value.Size = 2;
        pn.PlaceList.add(ile2);

        DataCarQueue ili3 = new DataCarQueue();
        ili3.SetName("ili3");
        ili3.Value.Size = 2;
        pn.PlaceList.add(ili3);

        DataCarQueue ile3 = new DataCarQueue();
        ile3.SetName("ile3");
        ile3.Value.Size = 2;
        pn.PlaceList.add(ile3);


        // WHEN going out from round about
        DataTransfer P_oli2 = new DataTransfer();
        P_oli2.SetName("P_oli2");
        P_oli2.Value = new TransferOperation("localhost", "1084", "P_oli2");
        pn.PlaceList.add(P_oli2);


        // TRANSITIONS--------------------------------------------------------------------------------------------------

        // ENTER THE ROUND ABOUT----------------------------------------------------------------------------------------

        // How the car goes from i1
        // Ti11 - intre i1 - ili1
        PetriTransition ti11 = new PetriTransition(pn);
        ti11.TransitionName = "Ti11";
        ti11.InputPlaceName.add("i1");

        Condition Ti11Ct1 = new Condition(ti11, "i1", TransitionCondition.NotNull);
        Condition Ti11Ct2 = new Condition(ti11, "ili1", TransitionCondition.CanAddCars);
        Ti11Ct1.SetNextCondition(LogicConnector.AND, Ti11Ct2);

        GuardMapping grdTi11 = new GuardMapping();
        grdTi11.condition = Ti11Ct1;
        grdTi11.Activations.add(new Activation(ti11, "i1", TransitionOperation.AddElement, "ili1"));
        ti11.GuardMappingList.add(grdTi11);

        ti11.Delay = 0;
        pn.Transitions.add(ti11);


        // Ti12 - intre ili1 - ili2
        PetriTransition ti12 = new PetriTransition(pn);
        ti12.TransitionName = "Ti12";
        ti12.InputPlaceName.add("ili1");

        Condition Ti12Ct1 = new Condition(ti12, "ili1", TransitionCondition.HaveCarForMe);
        Condition Ti12Ct2 = new Condition(ti12, "ili2", TransitionCondition.CanAddCars);
        Ti12Ct1.SetNextCondition(LogicConnector.AND, Ti12Ct2);

        GuardMapping grdTi12 = new GuardMapping();
        grdTi12.condition = Ti12Ct1;
        grdTi12.Activations.add(new Activation(ti12, "ili1", TransitionOperation.PopElementWithTargetToQueue, "ili2"));
        ti12.GuardMappingList.add(grdTi12);

        ti12.Delay = 0;
        pn.Transitions.add(ti12);

        // Ti13- intre ili2 - ili3
        PetriTransition ti13 = new PetriTransition(pn);
        ti13.TransitionName = "Ti13";
        ti13.InputPlaceName.add("ili2");

        Condition Ti13Ct1 = new Condition(ti13, "ili2", TransitionCondition.HaveCarForMe);
        Condition Ti13Ct2 = new Condition(ti13, "ili3", TransitionCondition.CanAddCars);
        Ti13Ct1.SetNextCondition(LogicConnector.AND, Ti13Ct2);

        GuardMapping grdTi13 = new GuardMapping();
        grdTi13.condition = Ti13Ct1;
        grdTi13.Activations.add(new Activation(ti13, "ili2", TransitionOperation.PopElementWithTargetToQueue, "ili3"));
        ti13.GuardMappingList.add(grdTi13);

        pn.Transitions.add(ti13);

        // Ti14 - intre ili3 - oli1
        PetriTransition ti14 = new PetriTransition(pn);
        ti14.TransitionName = "Ti14";
        ti14.InputPlaceName.add("ili3");

        Condition Ti14Ct1 = new Condition(ti14, "ili3", TransitionCondition.HaveCarForMe);

        GuardMapping grdTi14 = new GuardMapping();
        grdTi14.condition= Ti14Ct1;
        grdTi14.Activations.add(new Activation(ti14, "ili3", TransitionOperation.PopElementWithTarget, "oli1"));
        ti14.GuardMappingList.add(grdTi14);

        pn.Transitions.add(ti14);

        // Ti15 - intre ili2 - oli3
        PetriTransition ti15 = new PetriTransition(pn);
        ti15.TransitionName = "Ti15";
        ti15.InputPlaceName.add("ili2");

        Condition Ti15Ct1 = new Condition(ti15, "ili2", TransitionCondition.HaveCarForMe);

        GuardMapping grdTi15 = new GuardMapping();
        grdTi15.condition= Ti15Ct1;
        grdTi15.Activations.add(new Activation(ti15, "ili2", TransitionOperation.PopElementWithTarget, "oli3"));
        ti15.GuardMappingList.add(grdTi15);

        pn.Transitions.add(ti15);

        // Ti16 - intre ili3 - ili1
        PetriTransition ti16 = new PetriTransition(pn);
        ti16.TransitionName = "Ti16";
        ti16.InputPlaceName.add("ili3");

        Condition Ti16Ct1 = new Condition(ti16, "ili3", TransitionCondition.HaveCarForMe);
        Condition Ti16Ct2 = new Condition(ti16, "ili1", TransitionCondition.CanAddCars);
        Ti16Ct1.SetNextCondition(LogicConnector.AND, Ti16Ct2);

        GuardMapping grdTi16 = new GuardMapping();
        grdTi16.condition = Ti16Ct1;
        grdTi16.Activations.add(new Activation(ti16, "ili3", TransitionOperation.PopElementWithTargetToQueue, "ili1"));
        ti16.GuardMappingList.add(grdTi16);

        pn.Transitions.add(ti16);

        // Ti17 - intre ili1 - oli2
        PetriTransition ti17 = new PetriTransition(pn);
        ti17.TransitionName = "Ti17";
        ti17.InputPlaceName.add("ili1");

        Condition Ti17Ct1 = new Condition(ti17, "ili1", TransitionCondition.HaveCarForMe);

        GuardMapping grdTi17 = new GuardMapping();
        grdTi17.condition= Ti17Ct1;
        grdTi17.Activations.add(new Activation(ti17, "ili1", TransitionOperation.PopElementWithoutTarget, "oli2"));
        ti17.GuardMappingList.add(grdTi17);

        pn.Transitions.add(ti17);

        // How the car goes from e1
        // Te11 - intre e1 - ile1
        PetriTransition te11 = new PetriTransition(pn);
        te11.TransitionName = "Te11";
        te11.InputPlaceName.add("e1");

        Condition Te11Ct1 = new Condition(te11, "e1", TransitionCondition.NotNull);
        Condition Te11Ct2 = new Condition(te11, "ile1", TransitionCondition.CanAddCars);
        Te11Ct1.SetNextCondition(LogicConnector.AND, Te11Ct2);

        GuardMapping grdTe11 = new GuardMapping();
        grdTe11.condition = Te11Ct1;
        grdTe11.Activations.add(new Activation(te11, "e1", TransitionOperation.AddElement, "ile1"));
        te11.GuardMappingList.add(grdTe11);

        pn.Transitions.add(te11);

        // Te12 - intre ile1 - ile2
        PetriTransition te12 = new PetriTransition(pn);
        te12.TransitionName = "Te12";
        te12.InputPlaceName.add("ile1");

        Condition Te12Ct1 = new Condition(te12, "ile1", TransitionCondition.HaveCarForMe);
        Condition Te12Ct2 = new Condition(te12, "ile2", TransitionCondition.CanAddCars);
        Te12Ct1.SetNextCondition(LogicConnector.AND, Te12Ct2);

        GuardMapping grdTe12 = new GuardMapping();
        grdTe12.condition = Te12Ct1;
        grdTe12.Activations.add(new Activation(te12, "ile1", TransitionOperation.PopElementWithTargetToQueue, "ile2"));
        te12.GuardMappingList.add(grdTe12);

        pn.Transitions.add(te12);

        // Te13 - intre ile2 - ole3
        PetriTransition te13 = new PetriTransition(pn);
        te13.TransitionName = "Te13";
        te13.InputPlaceName.add("ile2");

        Condition Te13Ct1 = new Condition(te13, "ile2", TransitionCondition.HaveCarForMe);

        GuardMapping grdTe13 = new GuardMapping();
        grdTe13.condition= Te13Ct1;
        grdTe13.Activations.add(new Activation(te13, "ile2", TransitionOperation.PopElementWithTarget, "ole3"));
        te13.GuardMappingList.add(grdTe13);

        pn.Transitions.add(te13);

        // Te14 - intre ile2 - ile3
        PetriTransition te14 = new PetriTransition(pn);
        te14.TransitionName = "Te14";
        te14.InputPlaceName.add("ile2");

        Condition Te14Ct1 = new Condition(te14, "ile2", TransitionCondition.HaveCarForMe);
        Condition Te14Ct2 = new Condition(te14, "ile3", TransitionCondition.CanAddCars);
        Te14Ct1.SetNextCondition(LogicConnector.AND, Te14Ct2);

        GuardMapping grdTe14 = new GuardMapping();
        grdTe14.condition = Te14Ct1;
        grdTe14.Activations.add(new Activation(te14, "ile2", TransitionOperation.PopElementWithTargetToQueue, "ile3"));
        te14.GuardMappingList.add(grdTe14);

        pn.Transitions.add(te14);

        // Te15 - intre ile3 - ole1
        PetriTransition te15 = new PetriTransition(pn);
        te15.TransitionName = "Te15";
        te15.InputPlaceName.add("ile3");

        Condition Te15Ct1 = new Condition(te15, "ile3", TransitionCondition.HaveCarForMe);

        GuardMapping grdTe15 = new GuardMapping();
        grdTe15.condition= Te15Ct1;
        grdTe15.Activations.add(new Activation(te15, "ile3", TransitionOperation.PopElementWithTarget, "ole1"));
        te15.GuardMappingList.add(grdTe15);

        pn.Transitions.add(te15);

        // Te16 - intre ile3 - ile1
        PetriTransition te16 = new PetriTransition(pn);
        te16.TransitionName = "Te16";
        te16.InputPlaceName.add("ile3");

        Condition Te16Ct1 = new Condition(te16, "ile3", TransitionCondition.HaveCarForMe);
        Condition Te16Ct2 = new Condition(te16, "ile1", TransitionCondition.CanAddCars);
        Te16Ct1.SetNextCondition(LogicConnector.AND, Te16Ct2);

        GuardMapping grdTe16 = new GuardMapping();
        grdTe16.condition = Te16Ct1;
        grdTe16.Activations.add(new Activation(te16, "ile3", TransitionOperation.PopElementWithTargetToQueue, "ile1"));
        te16.GuardMappingList.add(grdTe16);

        pn.Transitions.add(te16);

        // Te17 - intre ile1 - ole2
        PetriTransition te17 = new PetriTransition(pn);
        te17.TransitionName = "Te17";
        te17.InputPlaceName.add("ile1");

        Condition Te17Ct1 = new Condition(te17, "ile1", TransitionCondition.HaveCarForMe);

        GuardMapping grdTe17 = new GuardMapping();
        grdTe17.condition= Te17Ct1;
        grdTe17.Activations.add(new Activation(te17, "ile1", TransitionOperation.PopElementWithTarget, "ole2"));
        te17.GuardMappingList.add(grdTe17);

        pn.Transitions.add(te17);


        // How the car goes from i2
        // Ti21 - intre i2 - ili2
        PetriTransition ti21 = new PetriTransition(pn);
        ti21.TransitionName = "Ti21";
        ti21.InputPlaceName.add("i2");

        Condition Ti21Ct1 = new Condition(ti21, "i2", TransitionCondition.NotNull);
        Condition Ti21Ct2 = new Condition(ti21, "ili2", TransitionCondition.CanAddCars);
        Ti21Ct1.SetNextCondition(LogicConnector.AND, Ti21Ct2);

        GuardMapping grdTi21 = new GuardMapping();
        grdTi21.condition = Ti21Ct1;
        grdTi21.Activations.add(new Activation(ti21, "i2", TransitionOperation.AddElement, "ili2"));
        ti21.GuardMappingList.add(grdTi21);

        pn.Transitions.add(ti21);

        // Ti22 - intre ili2 - oli3
        PetriTransition ti22 = new PetriTransition(pn);
        ti22.TransitionName = "Ti22";
        ti22.InputPlaceName.add("ili2");

        Condition Ti22Ct1 = new Condition(ti22, "ili2", TransitionCondition.HaveCarForMe);

        GuardMapping grdTi22 = new GuardMapping();
        grdTi22.condition= Ti22Ct1;
        grdTi22.Activations.add(new Activation(ti22, "ili2", TransitionOperation.PopElementWithTarget, "oli3"));
        ti22.GuardMappingList.add(grdTi22);

        pn.Transitions.add(ti22);

        // Ti23 = Ti13

        // Ti24 = Ti14

        // Ti25 = Ti16

        // Ti26 = Ti17


        // How the car goes from e2
        // Te21 - intre e2 - ile2
        PetriTransition te21 = new PetriTransition(pn);
        te21.TransitionName = "Te21";
        te21.InputPlaceName.add("e2");

        Condition Te21Ct1 = new Condition(te21, "e2", TransitionCondition.NotNull);
        Condition Te21Ct2 = new Condition(te21, "ile2", TransitionCondition.CanAddCars);
        Te21Ct1.SetNextCondition(LogicConnector.AND, Te21Ct2);

        GuardMapping grdTe21 = new GuardMapping();
        grdTe21.condition = Te21Ct1;
        grdTe21.Activations.add(new Activation(te21, "e2", TransitionOperation.AddElement, "ile2"));
        te21.GuardMappingList.add(grdTe21);

        pn.Transitions.add(te21);

        // Te22 - intre ile2 - ole3
        PetriTransition te22 = new PetriTransition(pn);
        te22.TransitionName = "Te22";
        te22.InputPlaceName.add("ile2");

        Condition Te22Ct1 = new Condition(te22, "ile2", TransitionCondition.HaveCarForMe);

        GuardMapping grdTe22 = new GuardMapping();
        grdTe22.condition= Te22Ct1;
        grdTe22.Activations.add(new Activation(te22, "ile2", TransitionOperation.PopElementWithTarget, "ole3"));
        te22.GuardMappingList.add(grdTe22);

        pn.Transitions.add(te22);

        // Te23 = Te14

        // Te24 = Te15

        // Te25 = Te16

        // Te26 = Te17

        // How the car goes from i3
        // Ti31 - intre i3 - ili3
        PetriTransition ti31 = new PetriTransition(pn);
        ti31.TransitionName = "Ti31";
        ti31.InputPlaceName.add("i3");

        Condition Ti31Ct1 = new Condition(ti31, "i3", TransitionCondition.NotNull);
        Condition Ti31Ct2 = new Condition(ti31, "ili3", TransitionCondition.CanAddCars);
        Ti31Ct1.SetNextCondition(LogicConnector.AND, Ti31Ct2);

        GuardMapping grdTi31 = new GuardMapping();
        grdTi31.condition = Ti31Ct1;
        grdTi31.Activations.add(new Activation(ti31, "i3", TransitionOperation.AddElement, "ili3"));
        ti31.GuardMappingList.add(grdTi31);

        pn.Transitions.add(ti31);

        // Ti32 = Ti16

        // Ti33 = Ti17

        // Ti34 = Ti12

        // Ti35 = Ti15

        // Ti36 = Ti13

        // Ti37 = Ti14

        // How the car goes from e3
        // Te31 - intre e3 - ile3
        PetriTransition te31 = new PetriTransition(pn);
        te31.TransitionName = "Te31";
        te31.InputPlaceName.add("e3");

        Condition Te31Ct1 = new Condition(te31, "e3", TransitionCondition.NotNull);
        Condition Te31Ct2 = new Condition(te31, "ile3", TransitionCondition.CanAddCars);
        Te31Ct1.SetNextCondition(LogicConnector.AND, Te31Ct2);

        GuardMapping grdTe31 = new GuardMapping();
        grdTe31.condition = Te31Ct1;
        grdTe31.Activations.add(new Activation(te31, "e3", TransitionOperation.AddElement, "ile3"));
        te31.GuardMappingList.add(grdTe31);

        pn.Transitions.add(te31);

        // Te32 = Te16

        // Te33 = Te17

        // Te34 = Te12

        // Te35 = Te22

        // Te36 = Te14

        // Te37 = Te15



        // Sending Over Network to middle street

        // T_oli2
        PetriTransition toli2 = new PetriTransition(pn);
        toli2.TransitionName = "T_oli2";
        toli2.InputPlaceName.add("oli2");

        Condition Toli2Ct1 = new Condition(toli2, "oli2", TransitionCondition.NotNull);

        GuardMapping grdToli2 = new GuardMapping();
        grdToli2.condition = Toli2Ct1;
        grdToli2.Activations.add(new Activation(toli2, "oli2", TransitionOperation.SendOverNetwork, "P_oli2"));
        toli2.GuardMappingList.add(grdToli2);

        toli2.Delay = 0;
        pn.Transitions.add(toli2);



        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);

        System.out.println("Exp1 started \n ------------------------------");
        pn.Delay = 2000;
        pn.Start();
    }
}
