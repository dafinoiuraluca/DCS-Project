package UVS;

import Components.*;
import DataObjects.DataFloat;
import DataObjects.DataString;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Pedestrian {
    public static void main(String[] args) {
        PetriNet pn1 = new PetriNet();
        pn1.PetriNetName = "Pedestrian";
        pn1.NetworkPort = 1082;

        DataFloat p0 = new DataFloat();
        p0.SetName("P0");
        p0.SetValue(1.0f);
        pn1.PlaceList.add(p0);

        DataString in1 = new DataString();
        in1.SetName("in1");
        pn1.PlaceList.add(in1);

        DataFloat p1 = new DataFloat();
        p1.SetName("P1");
        pn1.PlaceList.add(p1);


        // T0
        PetriTransition t0 = new PetriTransition(pn1);
        t0.TransitionName = "T0";
        t0.InputPlaceName.add("P0");
        t0.InputPlaceName.add("in1");

        Condition T0Ct1 = new Condition(t0, "P0", TransitionCondition.NotNull);
        Condition T0Ct2 = new Condition(t0, "in1", TransitionCondition.NotNull);
        T0Ct1.SetNextCondition(LogicConnector.AND, T0Ct2);

        GuardMapping grdT0 = new GuardMapping();
        grdT0.condition = T0Ct1;
        grdT0.Activations.add(new Activation(t0, "in1", TransitionOperation.Move, "P1"));
        grdT0.Activations.add(new Activation(t0, "P0", TransitionOperation.Move, "P0"));
        t0.GuardMappingList.add(grdT0);

        t0.Delay = 5;
        pn1.PlaceList.add(t0);

        System.out.println("Pedestrian button started \n ------------------------------");
        pn1.Delay = 2000;

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn1;
        frame.setVisible(true);
    }
}
