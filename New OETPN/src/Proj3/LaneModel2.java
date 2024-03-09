package Proj3;

import Components.*;
import DataObjects.DataString;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class LaneModel2 {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Main Petri";
        pn.NetworkPort = 1080;

        DataString input = new DataString();
        input.SetName("In");
        pn.PlaceList.add(input);

        DataString P0 = new DataString();
        P0.SetName("P0");
        P0.SetValue("1");
        pn.PlaceList.add(P0);

        DataString P1 = new DataString();
        P1.SetName("P1");
        pn.PlaceList.add(P1);

        //T0------------------------------
        PetriTransition t0 = new PetriTransition(pn);
        t0.TransitionName = "t0";
        t0.InputPlaceName.add("P0");
        t0.InputPlaceName.add("In");

        Condition T1Ct1 = new Condition(t0, "In", TransitionCondition.NotNull);
        Condition T1Ct2 = new Condition(t0, "P0", TransitionCondition.NotNull);
        T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

        GuardMapping grdT0 = new GuardMapping();
        grdT0.condition = T1Ct1;
        grdT0.Activations.add(new Activation(t0,"P0", TransitionOperation.Move, "P1"));
        grdT0.Activations.add(new Activation(t0,"P0", TransitionOperation.Move, "P0"));
        t0.GuardMappingList.add(grdT0);

        pn.Transitions.add(t0);
        t0.Delay = 0;

        System.out.println("Exp1 started \n ------------------------------");
        pn.Delay = 2000;
        //pn.Start();

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);
    }
}
