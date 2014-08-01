matrix(id, variable) ::= <<
{
	Jama.Matrix tmpMtx = <variable>;
	int i=0, j=0; String matrix = "{";
	for (i = 0; i \< tmpMtx.getRowDimension(); i++)
	{
		matrix += "{";
		
		for (j = 0; j \< tmpMtx.getColumnDimension(); j++)
		{
			matrix += tmpMtx.get(i,j);
			if (j != tmpMtx.getColumnDimension() - 1)
				matrix += ",";
			else 
				matrix += "}";
		}
		if (i != tmpMtx.getRowDimension() - 1)
			matrix += ",";
	}
	matrix += "}";
	org.eclipse.iee.core.EvaluationContextHolder.putResult("<id>", String.valueOf(matrix));
}
>>
