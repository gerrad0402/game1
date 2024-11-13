public class Test {
    public static void main(String[] args) {
        // Warrior와 Mage 객체 생성
        Warrior garen = new Warrior();
        Mage annie = new Mage();

        //객체 생성 및 챔피언에 장착
        Equipment sword = new Equipment("롱소드");
        Equipment staff = new Equipment("쓸데없이 큰 지팡이");

        // 아이템 장착
        garen.setEquipment(sword);
        annie.setEquipment(staff);

        // 아이템 사용
        garen.useEquipment();
        annie.useEquipment();

        // 오버라이딩된 메서드 호출
        garen.move();
        garen.spinAttack();
        garen.normalAttack();

        annie.move();
        annie.fireBall();
        annie.normalAttack();
    }
}


class Champion {
    String name;
    String job;
    String skill;
    Equipment equipment; // 포함 관계 설정

    void normalAttack() {
        System.out.println("기본 공격을 합니다.");
    }

    void move() {
        System.out.println("이동합니다.");
    }

    void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    void useEquipment() {
        if (equipment != null) {
            equipment.use();
        } else {
            System.out.println("장착된 아이템이 없습니다.");
        }
    }
}

class Warrior extends Champion {
    String shield;


    void spinAttack() {
        System.out.println("회전 공격을 합니다.");
    }


    @Override
    void normalAttack() {
        System.out.println("대검으로 공격합니다.");
    }


    @Override
    void move() {
        System.out.println("힘찬 걸음으로 이동합니다.");
    }
}


class Mage extends Champion {
    String mana;


    void fireBall() {
        System.out.println("화염구를 던집니다.");
    }


    @Override
    void normalAttack() {
        System.out.println("작은 화염 공격을 합니다.");
    }


    @Override
    void move() {
        System.out.println("느린 걸음으로 이동합니다.");
    }
}


class Equipment {
    String name;

    Equipment(String name) {
        this.name = name;
    }

    void use() {
        System.out.println(this.name + " 아이템을 사용합니다.");
    }
}
