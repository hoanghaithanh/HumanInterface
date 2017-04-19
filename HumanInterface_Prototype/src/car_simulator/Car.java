package car_simulator;

import java.util.ArrayList;

public class Car {
	
	//Define Door, false is closed, true is opened
	private boolean frontRightDoor;
	private boolean frontLeftDoor;
	private boolean rearRightDoor;
	private boolean rearLeftDoor;
	
	//Define light signal, false if off, true is on
	private boolean flashLight;
	private boolean rightSignalLight;
	private boolean leftSignalLight;
	
	private ArrayList<PeripheralDevice> deviceList;
	
	//
	public Car()
	{
		this.flashLight = this.frontLeftDoor = this.frontRightDoor = this.leftSignalLight = this.rearLeftDoor = this.rearRightDoor
				= this.rightSignalLight = false;
		
	}
	
	public Car(ArrayList<PeripheralDevice> arrayList)
	{
		this();
		this.deviceList = arrayList;
	}
	
	public boolean addDevice(PeripheralDevice device)
	{
		boolean check=false;
		if(!this.deviceList.contains(device))
		{
			this.deviceList.add(device);
			check = true;
		}
		else
		{
			System.out.println("Already have this device!");
		}
		return check;
	}
	
	public void openFrontRightDoor()
	{
		this.frontRightDoor = true;
	}
	
	public void clossFrontRightDoor()
	{
		this.frontRightDoor = false;
	}
	
	public void openFrontLeftDoor()
	{
		this.frontLeftDoor = true;
	}
	
	public void clossFrontLefttDoor()
	{
		this.frontLeftDoor = false;
	}
	
	public boolean turnOnDevice(String name)
	{
		boolean check = false;
		for(PeripheralDevice e:this.deviceList)
		{
			if(e.getName().equals(name))
			{
				e.turnOn();
				check = true;
			}
		}
		return check;
	}
	
	public boolean turnOffDevice(String name)
	{
		boolean check = false;
		for(PeripheralDevice e:this.deviceList)
		{
			if(e.getName().equals(name))
			{
				e.turnOff();
				check = true;
			}
		}
		return check;
	}
	
	public void turnOnCarPart(String name)
	{
		switch(name){
			case "flashLight":
				this.flashLight = true;
			case "rightSignalLight":
				this.rightSignalLight = true;
			case "leftSignalLight":
				this.leftSignalLight = true;
			default:
				System.out.println("Unknow Part!");
		}

	}
	
	public void turnOffCarPart(String name)
	{
		switch(name){
			case "flashLight":
				this.flashLight = false;
			case "rightSignalLight":
				this.rightSignalLight = false;
			case "leftSignalLight":
				this.leftSignalLight = false;
			default:
				System.out.println("Unknow Part!");
		}

	}
}