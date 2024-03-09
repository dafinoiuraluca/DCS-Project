package OETPN;

import java.util.ArrayList;

import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataFloat;
import DataObjects.DataSubPetriNet;
import DataObjects.DataTransfer;
import DataOnly.SubPetri;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Exp3_Part1 {

	public static PetriNet PN3() {
		// ----------------------- SubPetri ------------------------------------
		PetriNet mpn = new PetriNet();
		mpn.PetriNetName = "PN3";
		mpn.NetworkPort = 0;

		DataFloat constantVal1 = new DataFloat();
		constantVal1.SetName("constantVal1");
		constantVal1.SetValue(0.1f);
		mpn.ConstantPlaceList.add(constantVal1);

		DataFloat constantVal2 = new DataFloat();
		constantVal2.SetName("constantVal2");
		constantVal2.SetValue(3.0f);
		mpn.ConstantPlaceList.add(constantVal2);

		DataFloat p31 = new DataFloat();
		p31.SetName("p31");
		mpn.PlaceList.add(p31);

		DataFloat p32 = new DataFloat();
		p32.SetName("p32");
		mpn.PlaceList.add(p32);

		DataFloat p33 = new DataFloat();
		p33.SetName("p33");
		mpn.PlaceList.add(p33);

		DataFloat p34 = new DataFloat();
		p34.SetName("p34");
		mpn.PlaceList.add(p34);

		DataTransfer p35 = new DataTransfer();
		p35.SetName("p35");
		p35.Value = new TransferOperation("localhost", "1080", "p6");
		mpn.PlaceList.add(p35);

		DataFloat p36 = new DataFloat();
		p36.SetName("p36");
		mpn.PlaceList.add(p36);

		// T31 ------------------------------------------------
		PetriTransition t31 = new PetriTransition(mpn);
		t31.TransitionName = "t31";
		t31.InputPlaceName.add("p31");

		Condition T31Ct1 = new Condition(t31, "p31", TransitionCondition.NotNull);

		GuardMapping grdT31 = new GuardMapping();
		grdT31.condition = T31Ct1;

		ArrayList<String> lstInput = new ArrayList<>();
		lstInput.add("p31");
		lstInput.add("constantVal1");
		grdT31.Activations.add(new Activation(t31, lstInput, TransitionOperation.Add, "p36"));
		grdT31.Activations.add(new Activation(t31, lstInput, TransitionOperation.Add, "p32"));

		t31.GuardMappingList.add(grdT31);
		t31.Delay = 0;
		mpn.Transitions.add(t31);

		// T32 ------------------------------------------------
		PetriTransition t32 = new PetriTransition(mpn);
		t32.TransitionName = "t32";
		t32.InputPlaceName.add("p32");

		Condition T32Ct1 = new Condition(t32, "p32", TransitionCondition.NotNull);

		GuardMapping grdT32 = new GuardMapping();
		grdT32.condition = T32Ct1;

		grdT32.Activations.add(new Activation(t32, "p32", TransitionOperation.Move, "p33"));
		grdT32.Activations.add(new Activation(t32, "p32", TransitionOperation.Move, "p34"));

		t32.GuardMappingList.add(grdT32);
		t32.Delay = 0;
		mpn.Transitions.add(t32);

		// T33 ------------------------------------------------
		PetriTransition t33 = new PetriTransition(mpn);
		t33.TransitionName = "t33";
		t33.InputPlaceName.add("p34");

		Condition T33Ct1 = new Condition(t33, "p34", TransitionCondition.NotNull);

		GuardMapping grdT33 = new GuardMapping();
		grdT33.condition = T33Ct1;

		grdT33.Activations.add(new Activation(t33, "p34", TransitionOperation.SendOverNetwork, "p35"));
		grdT33.Activations.add(new Activation(t33, "p34", TransitionOperation.Move, "p31"));

		t33.GuardMappingList.add(grdT33);
		t33.Delay = 0;
		mpn.Transitions.add(t33);

		// T34 ------------------------------------------------
		PetriTransition t34 = new PetriTransition(mpn);
		t34.TransitionName = "t34";
		t34.InputPlaceName.add("p33");

		Condition t34Ct1 = new Condition(t34, "p33", TransitionCondition.NotNull);
		Condition t34Ct2 = new Condition(t34, "p33", TransitionCondition.MoreThanOrEqual, "constantVal2");
		t34Ct1.SetNextCondition(LogicConnector.AND, t34Ct2);

		GuardMapping grdT34 = new GuardMapping();
		grdT34.condition = t34Ct1;

		grdT34.Activations.add(new Activation(t34, "", TransitionOperation.StopPetriNet, ""));

		t34.GuardMappingList.add(grdT34);
		t34.Delay = 0;
		mpn.Transitions.add(t34);

		mpn.Delay = 1000;

		return mpn;
	}

	public static PetriNet PN4() {
		// SubPetri 4---------------------------------------------------------------------------------------------------
		PetriNet mpn = new PetriNet();
		mpn.PetriNetName = "PN4";
		mpn.NetworkPort = 0;

		DataFloat p41 = new DataFloat();
		p41.SetName("p41");
		mpn.PlaceList.add(p41);

		DataFloat p42 = new DataFloat();
		p42.SetName("p42");
		mpn.PlaceList.add(p42);

		DataFloat p43 = new DataFloat();
		p43.SetName("p43");
		mpn.PlaceList.add(p43);

		DataTransfer p44 = new DataTransfer();
		p44.SetName("p44");
		p44.Value = new TransferOperation("localhost", "1080", "p5");
		mpn.PlaceList.add(p44);

		DataFloat constantVal1 = new DataFloat();
		constantVal1.SetName("constantVal1");
		constantVal1.SetValue(0.2f);
		mpn.ConstantPlaceList.add(constantVal1);

		DataFloat constantVal2 = new DataFloat();
		constantVal2.SetName("constantVal2");
		constantVal2.SetValue(2.0f);
		mpn.ConstantPlaceList.add(constantVal2);

		DataFloat constantVal4 = new DataFloat();
		constantVal4.SetName("constantVal4");
		constantVal4.SetValue(4.0f);
		mpn.ConstantPlaceList.add(constantVal4);

		// T41----------------------------------------------------------------------------------------------------------
		PetriTransition t41 = new PetriTransition(mpn);
		t41.TransitionName = "t41";
		t41.InputPlaceName.add("p41");

		Condition T41Ct1 = new Condition(t41, "p41", TransitionCondition.NotNull);
		Condition T41Ct2 = new Condition(t41, "p42", TransitionCondition.MoreThanOrEqual, "constantVal2");
		T41Ct1.SetNextCondition(LogicConnector.AND, T41Ct2);

		// adds 0.2 to p41 and moves to p42
		GuardMapping grdT41 = new GuardMapping();
		grdT41.condition = T41Ct1;

		grdT41.Activations.add(new Activation(t41, "constantVal1", TransitionOperation.Add, "p42"));

		t41.GuardMappingList.add(grdT41);
		t41.Delay = 0;
		mpn.Transitions.add(t41);

		// T42----------------------------------------------------------------------------------------------------------
		PetriTransition t42 = new PetriTransition(mpn);
		t42.TransitionName = "t42";
		t42.InputPlaceName.add("t42");

		Condition T42Ct1 = new Condition(t42, "p42", TransitionCondition.NotNull);

		GuardMapping grdT42 = new GuardMapping();
		grdT42.condition = T42Ct1;

		grdT42.Activations.add(new Activation(t42, "p42", TransitionOperation.Move, "p43"));

		t42.GuardMappingList.add(grdT42);
		t42.Delay = 0;
		mpn.Transitions.add(t42);

		// T43----------------------------------------------------------------------------------------------------------
		PetriTransition t43 = new PetriTransition(mpn);
		t43.TransitionName = "t43";
		t43.InputPlaceName.add("t43");

		Condition T43Ct1 = new Condition(t43, "p43", TransitionCondition.LessThan, "constantVal4");

		GuardMapping grdT43 = new GuardMapping();
		grdT43.condition = T43Ct1;

		grdT43.Activations.add(new Activation(t43, "p43", TransitionOperation.SendOverNetwork, "p44"));
		grdT43.Activations.add(new Activation(t43, "p43", TransitionOperation.Move, "p41"));

		t43.GuardMappingList.add(grdT43);
		t43.Delay = 0;
		mpn.Transitions.add(t43);

		// T44----------------------------------------------------------------------------------------------------------
		PetriTransition t44 = new PetriTransition(mpn);
		t44.TransitionName = "t44";
		t44.InputPlaceName.add("t44");

		//checks if p43 is more than 4 then stop the petri net
		Condition T44Ct1 = new Condition(t44, "p43", TransitionCondition.MoreThan, "constantVal4");

		GuardMapping grdT44 = new GuardMapping();
		grdT44.condition = T44Ct1;

		grdT44.Activations.add(new Activation(t44, "p43", TransitionOperation.StopPetriNet, ""));

		t44.GuardMappingList.add(grdT44);
		t44.Delay = 0;
		mpn.Transitions.add(t44);

		return mpn;
	}

	public static void main(String[] args) {
		PetriNet pn = new PetriNet();
		pn.PetriNetName = "PN1";
		pn.NetworkPort = 1080;

		// ------------------------------------------------------------------------

		DataSubPetriNet SP = new DataSubPetriNet();
		SP.SetName("PN3");
		SubPetri pn3 = new SubPetri(PN3());
		SP.SetValue(pn3);
		pn.ConstantPlaceList.add(SP);

		DataSubPetriNet SP1 = new DataSubPetriNet();
		SP1.SetName("PN4");
		SubPetri pn4 = new SubPetri(PN4());
		SP1.SetValue(pn4);
		pn.ConstantPlaceList.add(SP1);

		DataFloat p1 = new DataFloat();
		p1.SetName("p1");
		p1.SetValue(2.0f);
		pn.PlaceList.add(p1);

		DataFloat p2 = new DataFloat();
		p2.SetName("p2");
		p2.SetValue(2.0f); //testing
		pn.PlaceList.add(p2);

		DataSubPetriNet p3 = new DataSubPetriNet();
		p3.SetName("p3");
		pn.PlaceList.add(p3);

		DataTransfer p3Send = new DataTransfer();
		p3Send.SetName("p3Send");
		p3Send.Value = new TransferOperation("localhost", "1090", "p22");
		pn.PlaceList.add(p3Send);

		DataFloat p4 = new DataFloat();
		p4.SetName("p4");
		pn.PlaceList.add(p4);

		DataFloat p5 = new DataFloat();
		p5.SetName("p5");
		pn.PlaceList.add(p5);

		DataFloat p6 = new DataFloat();
		p6.SetName("p6");
		pn.PlaceList.add(p6);

		DataFloat p7 = new DataFloat();
		p7.SetName("p7");
		pn.PlaceList.add(p7);

		// T1 ------------------------------------------------
		PetriTransition t1 = new PetriTransition(pn);
		t1.TransitionName = "t1";
		t1.InputPlaceName.add("p1");
		t1.InputPlaceName.add("p2");

		Condition T1Ct1 = new Condition(t1, "p1", TransitionCondition.NotNull);
		Condition T1Ct2 = new Condition(t1, "p2", TransitionCondition.NotNull);
		T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

		GuardMapping grdT1 = new GuardMapping();
		grdT1.condition = T1Ct1;

		grdT1.Activations.add(new Activation(t1, "PN3", TransitionOperation.Copy, "p3"));
		grdT1.Activations.add(new Activation(t1, "PN4", TransitionOperation.Copy, "p5"));
		grdT1.Activations.add(new Activation(t1, "p1", TransitionOperation.Move, "p4"));
		grdT1.Activations.add(new Activation(t1, "p2", TransitionOperation.Move, "p3-p31"));

		t1.GuardMappingList.add(grdT1);
		t1.Delay = 0;
		pn.Transitions.add(t1);

		// T1 Send ------------------------------------------------
		PetriTransition t1Send = new PetriTransition(pn);
		t1Send.TransitionName = "t1Send";
		t1Send.InputPlaceName.add("p3");

		Condition T1SendCt1 = new Condition(t1Send, "p3", TransitionCondition.NotNull);

		GuardMapping grdT1Send = new GuardMapping();
		grdT1Send.condition = T1SendCt1;

		grdT1Send.Activations.add(new Activation(t1Send, "p3", TransitionOperation.SendPetriNetOverNetwork, "p3Send"));

		t1Send.GuardMappingList.add(grdT1Send);
		t1Send.Delay = 0;
		pn.Transitions.add(t1Send);

		// T2 ------------------------------------------------
		PetriTransition t2 = new PetriTransition(pn);
		t2.TransitionName = "t2";
		t2.InputPlaceName.add("p5");
		t2.InputPlaceName.add("p6");

		Condition T2Ct1 = new Condition(t2, "p5", TransitionCondition.NotNull);
		Condition T2Ct2 = new Condition(t2, "p6", TransitionCondition.NotNull);
		T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);

		GuardMapping grdT2 = new GuardMapping();
		grdT2.condition = T2Ct1;

		grdT2.Activations.add(new Activation(t2, "p5", TransitionOperation.Move, "p1"));
		grdT2.Activations.add(new Activation(t2, "p6", TransitionOperation.Move, "p7"));

		t2.GuardMappingList.add(grdT2);
		t2.Delay = 0;
		pn.Transitions.add(t2);

		//  ------------------------------------------------
		PetriTransition t3 = new PetriTransition(pn);
		t3.TransitionName = "t3";
		t3.InputPlaceName.add("p4");

		Condition T3Ct1 = new Condition(t3, "p4", TransitionCondition.NotNull);

		GuardMapping grdT3 = new GuardMapping();
		grdT3.condition = T3Ct1;

		grdT3.Activations.add(new Activation(t3, "p4", TransitionOperation.Move, "p5"));

		t3.GuardMappingList.add(grdT3);
		t3.Delay = 0;
		pn.Transitions.add(t3);

		System.out.println("Exp3 part 1 started \n ------------------------------");
		pn.Delay = 5000;

		PetriNetWindow frame = new PetriNetWindow(false);
		frame.petriNet = pn;
		frame.setVisible(true);
	}
}