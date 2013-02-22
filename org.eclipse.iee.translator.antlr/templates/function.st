
function(name, params, value) ::= <<
	class <name>
	{
		public double compute(<params:{ param | double <param>}; separator=", ">)
			{ return <value>; }
	}
>>