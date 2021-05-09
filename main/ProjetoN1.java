package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ProjetoN1 {

	public static void main(String[] args) {
		
		// < Setup >
		Scanner scn = new Scanner(System.in);
		Random rdn = new Random();
		int input = 0;
		int random = 0;
		int hasValueUser = 0;
		int hasValueMachine = 0;
		int caracteristica = 0;
		double user;
		double machine;
		boolean ganhador = false;
		boolean superEffectiveUser = false;
		boolean superEffectiveMachine = false;
		List<Monstrinho> monstros = Monstrinho.getMonstrinhos();
		List<Monstrinho> monstrosUsuario = new ArrayList<Monstrinho>();
		List<Monstrinho> monstrosMaquina = new ArrayList<Monstrinho>();
		// < Setup >
		
		// < Show Pokemons >
		for (Monstrinho monstrinho : monstros) 
		{
			System.out.println(monstrinho.toString());
		}
		System.out.println();
		// < Show Pokemons >
		
		// < Get User Pokemons >
		for(int i=0; i<6; i++)
		{
			System.out.println("Escolha um pokemon entre [1] .. [16]");
			input = scn.nextInt();
			if( input > 0 && input <= 16)
			{
				monstrosUsuario.add(monstros.get(input-1));
				monstros.set(input-1, null);
			}
		}
		// < Get User Pokemons >
		
		// < Get PC Pokemons >
		for(int i=0; i<16; i++)
		{
			random = rdn.nextInt(16);
			Monstrinho mRandom = monstros.get(random);
			if (mRandom != null)
			{
				if (monstrosMaquina.size() >= 6)
					break;
				monstrosMaquina.add(mRandom);
				monstros.set(random, null);
			}
		}
		// < Get PC Pokemons >
		
		while(true)
		{
			
			// < Check if still there is pokemons on the list. >
			for(int i=0;i<6;i++)
			{
				if (monstrosUsuario.get(i) != null)
					hasValueUser++;
				if (monstrosMaquina.get(i) != null)
					hasValueMachine++;				
			}
			
			if (hasValueUser == 0)
				break;
			else if (hasValueMachine == 0)
				break;
			
			hasValueUser = 0;
			hasValueMachine = 0;
			// < Check if still there is pokemons on the list. >
			
			// < Preparando Luta >
			System.out.println();
			for (int i=0; i<monstrosUsuario.size(); i++)
			{
				if(monstrosUsuario.get(i) != null)
					System.out.println( (i+1) + ": " + monstrosUsuario.get(i).toString() + "\n" );
				
			}
			
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.println("Escolha um pokemon!");
			input = scn.nextInt();
			
			if (input > 0 && input <= 6)
			{
				input -= 1;
				
				
				// < Get a pokemon that does not passed out >
				
				random = rdn.nextInt(6);
				if (monstrosMaquina.get(random) == null)
				{
					while(monstrosMaquina.get(random) == null)
					{
						random = rdn.nextInt(6);
					}
				}
				Monstrinho mPc = monstrosMaquina.get(random);								
				
				// < Get a pokemon that does not passed out >
				
				
				if (monstrosUsuario.get(input) != null)
				{
					Monstrinho mUser = monstrosUsuario.get(input);
					if (ganhador)
					{
						System.out.println(mUser.toString());
						System.out.println("Escolha uma carecteristica do seu pokemon: ");
						System.out.println("1 -> Forca, 2 -> Defesa, 3 -> Velocidade, 4 -> Vida");
						caracteristica = scn.nextInt();
					}
					else
						caracteristica = rdn.nextInt(4) + 1;
					
			// < Preparando Luta >
					
					superEffectiveUser = false;
					superEffectiveMachine = false;
					
					// < Set who gets the better type >
					if (mUser.getTipo() == "Water" && mPc.getTipo() == "Fire")
						superEffectiveUser = true;
					
					else if (mUser.getTipo() == "Fire" && mPc.getTipo() == "Grass")
						superEffectiveUser = true;
					
					else if (mUser.getTipo() == "Grass" && mPc.getTipo() == "Eletric")
						superEffectiveUser = true;
					
					else if (mUser.getTipo() == "Eletric" && mPc.getTipo() == "Water")
						superEffectiveUser = true;
					
					else if (mPc.getTipo() == "Water" && mUser.getTipo() == "Fire")
						superEffectiveMachine = true;
					
					else if (mPc.getTipo() == "Fire" && mUser.getTipo() == "Grass")
						superEffectiveMachine = true;
					
					else if (mPc.getTipo() == "Grass" && mUser.getTipo() == "Eletric")
						superEffectiveMachine = true;
					
					else if (mPc.getTipo() == "Eletric" && mUser.getTipo() == "Water")
						superEffectiveMachine = true;
					// < Set who gets the better type >
					
					// < Duelo >
					switch(caracteristica)
					{
						case 1:
							// Forca
							if(superEffectiveUser)
							{
								user = mUser.getForca() - mPc.getForca();
								machine = mPc.getForca() - (mUser.getForca() * 1.5);
							}
							else if(superEffectiveMachine)
							{
								user = mUser.getForca() - (mPc.getForca() * 1.5);
								machine = mPc.getForca() - mUser.getForca();
							}
							else
							{
								user = mUser.getForca() - mPc.getForca();
								machine = mPc.getForca() - mUser.getForca();
							}
							
							// < Set who passed out >
							if (user < machine)
							{
								monstrosUsuario.get(input).setDesmaiado(true);
								monstrosUsuario.set(input, null);
								ganhador = false;
							}
							else if (user > machine)
							{
								monstrosMaquina.get(random).setDesmaiado(true);
								monstrosMaquina.set(random, null);
								ganhador = true;						
							}
							else
							{
								monstrosUsuario.get(input).setDesmaiado(true);
								monstrosUsuario.set(input, null);
								monstrosMaquina.get(random).setDesmaiado(true);
								monstrosMaquina.set(random, null);
								ganhador = false;
							}
							// < Set who passed out >
								
							break;
						case 2:
							// Defesa
							
							if(superEffectiveUser)
							{
								user = mUser.getDefesa() - mPc.getDefesa();
								machine = mPc.getDefesa() - (mUser.getDefesa() * 1.5);
							}
							else if(superEffectiveMachine)
							{
								user = mUser.getDefesa() - (mPc.getDefesa() * 1.5);
								machine = mPc.getDefesa() - mUser.getDefesa();
							}
							else
							{
								user = mUser.getDefesa() - mPc.getDefesa();
								machine = mPc.getDefesa() - mUser.getDefesa();
							}
							
							// < Set who passed out >
							if (user < machine)
							{
								monstrosUsuario.get(input).setDesmaiado(true);
								monstrosUsuario.set(input, null);
								ganhador = false;
							}
							else if (user > machine)
							{
								monstrosMaquina.get(random).setDesmaiado(true);
								monstrosMaquina.set(random, null);
								ganhador = true;						
							}
							else
							{
								monstrosUsuario.get(input).setDesmaiado(true);
								monstrosUsuario.set(input, null);
								monstrosMaquina.get(random).setDesmaiado(true);		
								monstrosMaquina.set(random, null);
								ganhador = false;
							}
							// < Set who passed out >
								
							break;
						case 3:
							// Velocidade
							
							if(superEffectiveUser)
							{
								user = mUser.getVelocidade() - mPc.getVelocidade();
								machine = mPc.getVelocidade() - (mUser.getVelocidade() * 1.5);
							}
							else if(superEffectiveMachine)
							{
								user = mUser.getVelocidade() - (mPc.getVelocidade() * 1.5);
								machine = mPc.getVelocidade() - mUser.getVelocidade();
							}
							else
							{
								user = mUser.getVelocidade() - mPc.getVelocidade();
								machine = mPc.getVelocidade() - mUser.getVelocidade();
							}
							
							// < Set who passed out >						
							if (user < machine)
							{
								monstrosUsuario.get(input).setDesmaiado(true);
								monstrosUsuario.set(input, null);
								ganhador = false;
							}
							else if (user > machine)
							{
								monstrosMaquina.get(random).setDesmaiado(true);
								monstrosMaquina.set(random, null);
								ganhador = true;						
							}
							else
							{
								monstrosUsuario.get(input).setDesmaiado(true);
								monstrosUsuario.set(input, null);
								monstrosMaquina.get(random).setDesmaiado(true);
								monstrosMaquina.set(random, null);
								ganhador = false;
							}
							// < Set who passed out >
								
							break;
						case 4:
							// Vida
							
							if(superEffectiveUser)
							{
								user = mUser.getVida() - mPc.getVida();
								machine = mPc.getVida() - (mUser.getVida() * 1.5);
							}
							else if(superEffectiveMachine)
							{
								user = mUser.getVida() - (mPc.getVida() * 1.5);
								machine = mPc.getVida() - mUser.getVida();
							}
							else
							{
								user = mUser.getVida() - mPc.getVida();
								machine = mPc.getVida() - mUser.getVida();
							}
							
							// < Set who passed out >
							if (user < machine)
							{
								monstrosUsuario.get(input).setDesmaiado(true);
								monstrosUsuario.set(input, null);
								ganhador = false;
							}
							else if (user > machine)
							{
								monstrosMaquina.get(random).setDesmaiado(true);
								monstrosMaquina.set(random, null);
								ganhador = true;						
							}
							else
							{
								monstrosUsuario.get(input).setDesmaiado(true);
								monstrosUsuario.set(input, null);
								monstrosMaquina.get(random).setDesmaiado(true);
								monstrosMaquina.set(random, null);
								ganhador = false;
							}
							// < Set who passed out >
							
							break;
							
					}
					// < Duelo >				
					
				}
				
				else
					System.out.println("Este Monstro esta desmaiado!");
			}
		}
		
		// Ganha quer tiver monstros para lutar
		if (monstrosMaquina.isEmpty())
			System.out.println("O usuário ganhou!");
		else
			System.out.println("A máquina ganhou!");
		
		scn.close();
	}

}
