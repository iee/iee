
functionCall(new, name, fields, params) ::= <<
	<new> <name> ().init(<fields:{ field | <field>}; separator=", ">).compute(<params:{ param | <param>}; separator=", ">)
>>