package DOSW.Semana3;


interface Character {
    void attack();
    String getDescription();
}

class BaseCharacter implements Character {
    private final String name;
    private final String armor;
    private final String weapon;
    private final String skill;

    public BaseCharacter(String name, String armor, String weapon, String skill) {
        this.name = name;
        this.armor = armor;
        this.weapon = weapon;
        this.skill = skill;
    }

    @Override
    public void attack() {
        System.out.println(name + " ejecuta ataque base usando [" + weapon + "] y habilidad [" + skill + "].");
    }

    @Override
    public String getDescription() {
        return name + " (Armadura: " + armor + ")";
    }
}


class WarriorBuilder {
    private String name;
    private String armor = "Ninguna";
    private String weapon = "Puños";
    private String skill = "Golpe Básico";

    public WarriorBuilder(String name) {
        this.name = name;
    }

    public WarriorBuilder setArmor(String armor) {
        this.armor = armor;
        return this;
    }

    public WarriorBuilder setWeapon(String weapon) {
        this.weapon = weapon;
        return this;
    }

    public WarriorBuilder setSkill(String skill) {
        this.skill = skill;
        return this;
    }

    public Character build() {
        return new BaseCharacter(name, armor, weapon, skill);
    }
}


abstract class CharacterDecorator implements Character {
    protected Character wrapper;

    public CharacterDecorator(Character wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public void attack() {
        wrapper.attack();
    }

    @Override
    public String getDescription() {
        return wrapper.getDescription();
    }
}

class ShieldDecorator extends CharacterDecorator {
    public ShieldDecorator(Character wrapper) {
        super(wrapper);
    }

    @Override
    public void attack() {
        super.attack();
        System.out.println("   -> [Defensa Pasiva]: El Escudo de Hielo mitiga el contraataque enemigo.");
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + [Poder: Escudo de Hielo]";
    }
}

class SpeedDecorator extends CharacterDecorator {
    public SpeedDecorator(Character wrapper) {
        super(wrapper);
    }

    @Override
    public void attack() {
        System.out.println("   -> [Acción Extra]: Velocidad extrema permite un ataque preventivo.");
        super.attack();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + [Poder: Velocidad Extra]";
    }
}


public class Reto4 {
    public static void main(String[] args) {
        System.out.println("=== 1. FASE DE CONSTRUCCIÓN (BUILDER) ===");
        WarriorBuilder builder = new WarriorBuilder("Kael'thas el Guerrero");

        Character warrior = builder.setArmor("Acero Pesado")
                .setWeapon("Espada de Fuego")
                .setSkill("Furia Berserker")
                .build();

        System.out.println("Personaje creado: " + warrior.getDescription());
        warrior.attack();

        System.out.println("\n=== 2. FASE DE PARTIDA - OBTIENE ESCUDO (DECORATOR) ===");
        Character shieldedWarrior = new ShieldDecorator(warrior);
        System.out.println("Estado: " + shieldedWarrior.getDescription());
        shieldedWarrior.attack();

        System.out.println("\n=== 3. FASE DE PARTIDA - OBTIENE VELOCIDAD (DECORATOR ACUMULATIVO) ===");
        Character poweredWarrior = new SpeedDecorator(shieldedWarrior);
        System.out.println("Estado: " + poweredWarrior.getDescription());
        poweredWarrior.attack();

        System.out.println("\n=== 4. EFECTOS TERMINAN ===");
        System.out.println("Estado: " + warrior.getDescription());
        warrior.attack();
    }
}
