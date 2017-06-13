package codes;


public class Graphics
{

	public static void displaySlots(Board slots)
	{
		System.out.println();

		for(int c = 0; c < slots.getColumns(); c++)
			System.out.print((c+1) + " ");

		System.out.println();
		System.out.println();

		for(int a = slots.getRows()-1; a >= 0; a--)
		{
			for(int b = 0; b < slots.getColumns(); b++)
			{
				if(slots.getSlots(a, b) == 1)
					System.out.print("#" + " ");
				else if (slots.getSlots(a, b) == 2)
					System.out.print("@" + " ");
				else if (slots.getSlots(a, b) == 0)
					System.out.print("=-" + " ");
			}
				//System.out.print(slots.getSlots(a, b) + " ");

			System.out.println();
		}
	}

	public static void displayMessage(String message)
	{
		System.out.println();
		System.out.println(message);
	}

}
