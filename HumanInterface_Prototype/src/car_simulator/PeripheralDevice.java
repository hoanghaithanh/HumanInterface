package car_simulator;

public abstract class PeripheralDevice {
	private String name;
	private boolean status;
	
	public boolean turnOn()
	{
		this.status = true;
		return this.status;
	};
	public boolean turnOff()
	{
		this.status = false;
		return this.status == false;
	};
	
	protected void setName()
	{
		this.name = this.getClass().getName();
	}
	
	@Override
	public boolean equals(Object ob)
	{
		if(ob instanceof PeripheralDevice)
		{
			return (((PeripheralDevice) ob).getName().equals(this.getName()));
		}
		return false;
	}
	
	protected String getName()
	{
		return this.name;
	}
	
	public PeripheralDevice()
	{
		setName();
		this.status = false;
	}
}