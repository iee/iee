
anonymousFunction(param, value, variables) ::= <<
	new Function()
	{
		<variables:{ v | private double <v>;}; separator="">
		public Function init(<variables:{ v | double <v>}; separator=", ">)
		{
			<variables:{ v | this.<v> = <v>;}; separator="">
			return this;
		} 
		public double compute(double <param>)
			{ return <value>; }
	}.init(<variables:{ v | <v>}; separator=", ">)
>>