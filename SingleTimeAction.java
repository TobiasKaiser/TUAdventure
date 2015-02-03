
public abstract class SingleTimeAction extends Action { // ein bisschen überflüssig, könnte man auch mit disable() realisieren (Altlasten...)

	@Override
	protected void done() {
		this.disable();
	}

}
