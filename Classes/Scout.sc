Scout {
	var actions;

    *new {
		^super.new.init();
    }

	init {
		actions = ();
	}

	show_actions{
		actions.keys.do({arg key;
			key.postln;
		});
		^actions.keys;
	}

	set_actions{arg new_actions;
		new_actions.keys.do({arg new_action;
			if(actions[new_action].notNil,{
				actions[new_action] = new_actions[new_action];
			}, {
				this.prActionNotUnderstoodError();
			});
		});
		^actions;
	}

	call_action{arg action, args;
		if(actions[action].notNil and: actions[action].size > 0,{
			actions[action].do({arg function;
				function.value(args)
			});
		});

		if(actions[action].isNil,{
			this.prActionNotUnderstoodError();
		});
		^nil;
	}

	prActionNotUnderstoodError{
		"this scout cannot understand this action".error;
		^nil;
	}


}


