
functionCall(new, name, fields, params, class) ::= <<
	<if(class)>
		<new> <name> ().init(<fields:{ field | <field>}; separator=", ">).compute(<params:{ param | <param>}; separator=", ">)
	<else>
		<name> (<params:{ param | <param>}; separator=", ">)
	<endif>
>>