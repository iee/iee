
matrix(type, id, variable, path) ::= <<
	new Runnable() {
		private <type> variable;
		private Runnable init (<type> var)
		{
			variable = var; return this;
		}
		@Override
		public void run() {
			int i=0, j=0; String matrix = "{";
			for (i = 0; i \< variable.getRowDimension(); i++)
			{
				matrix += "{";
				
				for (j = 0; j \< variable.getColumnDimension(); j++)
				{
					matrix += variable.get(i,j);
					if (j != variable.getColumnDimension() - 1)
						matrix += ",";
					else 
						matrix += "}";
				}
				if (i != variable.getRowDimension() - 1)
					matrix += ",";
			}
			matrix += "}";
			File file = new File("<path>/<id>");
			try {
				FileUtils.writeStringToFile(file, "" + matrix);
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}.init(<variable>).run();
>>