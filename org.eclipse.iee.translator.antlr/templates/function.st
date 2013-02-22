
function(name, params, value, variables) ::= <<
	class <name>
	{
		<variables:{ v | private double <v>;}; separator="">
		public <name> init(<variables:{ v | double <v>}; separator=", ">)
		{
			<variables:{ v | this.<v> = <v>;}; separator="">
			return this;
		} 
		public double compute(<params:{ param | double <param>}; separator=", ">)
			{ return <value>; }
	}
>>