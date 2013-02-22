
variable(type, id, variable, path) ::= <<
	new Runnable() {
		private  <type> variable;
		private Runnable init (<type> var)
		{
			variable = var;return this;
		}
		@Override
		public void run() {
			File file = new File("<path>/<id>");
			try {
				FileUtils.writeStringToFile(file, "" + variable);
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}.init(<variable>).run();
>>