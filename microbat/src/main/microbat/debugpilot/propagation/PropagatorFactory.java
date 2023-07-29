package microbat.debugpilot.propagation;

import microbat.debugpilot.propagation.BP.ProbInfer;
import microbat.debugpilot.propagation.spp.SPPCF;
import microbat.debugpilot.propagation.spp.SPPH;
import microbat.debugpilot.propagation.spp.SPPRL;
import microbat.debugpilot.propagation.spp.SPPRLTrain;
import microbat.debugpilot.propagation.spp.SPPRandom;
import microbat.debugpilot.settings.PropagatorSettings;
import microbat.log.Log;

public class PropagatorFactory {
	
	private PropagatorFactory() {}

	public static ProbabilityPropagator getPropagator(final PropagatorSettings propagatorSettings) {
		switch(propagatorSettings.getPropagatorType()) {
		case None:
			return new EmptyPropagator();
		case ProfInfer:
			return new ProbInfer(propagatorSettings);
		case SPP_CF:
			return new SPPCF(propagatorSettings);
		case SPP_COST:
			return new SPPH(propagatorSettings);
		case SPP_RL:
			return new SPPRL(propagatorSettings);
		case SPP_RL_TRAIN:
			return new SPPRLTrain(propagatorSettings);
		case SPP_Random:
			return new SPPRandom(propagatorSettings);
		default:
			throw new RuntimeException(Log.genMsg(PropagatorFactory.class, "Undefined propagator type: " + propagatorSettings.getPropagatorType()));
		}
	}
}
