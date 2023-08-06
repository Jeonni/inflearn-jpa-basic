package hellojpa;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        // [엔티티 매니저 팩토리] - 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // [엔티티 매니저] - 생성
        EntityManager em = emf.createEntityManager();
        // [트랜잭션] - 획득
        EntityTransaction tx = em.getTransaction(); // 트랜잭션 API

        // * * JPA를 사용하면 항상 트랜잭션 안에서 데이터를 변경해야 함 !!!! * *
        try {
            tx.begin(); // [트랜잭션] - 시작

            // ----------- 비즈니스 로직 실행 (등록) -----------
//            Member member = new Member();
//
//            member.setId(5L);
//            member.setName("젼");
//
//            em.persist(member); // [엔티티 매니저] - 등록
            // ----------- --------------------- -----------


            // ----------- 비즈니스 로직 실행 (수정) -----------
//            Member member = em.find(Member.class, 5L);
//            member.setName("이젼(수정)");
            // ----------- --------------------- -----------

            // ----------- 비즈니스 로직 실행 (삭제) -----------
//            Member member = em.find(Member.class, 5L);
//            em.remove(member);
//          // ----------- --------------------- -----------

            // ----------- 비즈니스 로직 실행 (조회) -----------
            // JPA: 엔티티 객체를 중심으로 개발
            // JPQL: "엔티티 객체"를 대상으로 쿼리 (= 클래스와 필드를 대상으로 쿼리 한다.)
            // - em.createQuery(JPQL, 반환 타입) 메소드 실행 -> 쿼리 객체 생성 -> 쿼리 객체의 getResultList() 메소드 호출
            // JPQL <-> SQL의 차이
            // SQL: "데이터베이스 테이블"을 대상으로 쿼리
//            List<Member> result = em.createQuery("select m from Member as m", Member.class).getResultList();
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }
            // ----------- --------------------- -----------


//            // 비영속
//            Member member = new Member();
//            member.setId(100L);
//            member.setName("testMember");
//
//            // 영속
//            System.out.println(" --------before--------- ");
//            em.persist(member); // 1차 캐시에 저장
//            // 준영속
////            em.detach(member); // 회원 엔티티를 영속성 컨텍스트에서 분리, 준영속 상태
//            System.out.println(" --------after--------- ");
//            // Case1: 1차 캐시에서 조회
//            Member findMember = em.find(Member.class, 100L); // 1차 캐시에서 조회 => select 쿼리 X
//
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

//            // Case2: 데이터베이스에서 조회
//            Member findMember1 = em.find(Member.class, 100L); // DB에서 조회 => select 쿼리 => 1차 캐시에 저장
//            Member findMember2 = em.find(Member.class, 100L); // 1차 캐시에서 조회
//
//            // 영속 엔티티의 동일성 보장
//            // IMPORTANT: 같은 트랜잭션 안에서만 동일성 보장 !!
//            System.out.println("result = " + (findMember1 == findMember2)); // 동일성 비교 시 true


//            // Case3: 엔티티 등록
//            // - 엔티티 매니저는 트랜잭션을 커밋하기 전까지 DB에 엔티티를 저장 X => 내부 쿼리 저장소에 INSERT SQL 모아둠
//            // - 트랜잭션 커밋 시에, 모아둔 쿼리를 데이터베이스에 보냄 < == 이것이 트랜잭션을 지원하는 "쓰기 지연"이라 함
//            Member member1 = new Member(110L, "A");
//            Member member2 = new Member(111L, "B");
//
//            em.persist(member1);
//            em.persist(member2);
//
//            System.out.println(" ======================== "); // 이 이후에 inset 쿼리문 출력

//            // Case4: 엔티티 수정
//            // - 더티체킹(Dirty Checking): 엔티티의 변경사항을 데이터베이스에 자동으로 반영하는 변경감지 기능 => set만 해주면 엔티티 수정 가능
//            // 영속 엔티티 조회
//            Member member = em.find(Member.class, 100L);
//            // 영속 엔티티 데이터 수정
//            member.setName("edit");
//
//            // Q. em.update(member) 또는 em.persist(member)로 다시 저장해야 하지 않을까?
//            // - 처음 persist를 통해 1차 캐시에 저장할 때 동시에 스냅샷 필드도 저장한다.
//            // - 그리고 나서 commit() 또는 flush()가 일어날 때 엔티티와 스냅샷을 비교해서, 변경사항이 있을 경우 UPDATE SQL 을 알아서 만들어 DB에 저장한다.
//            // => 결론: 영속 상태의 엔티티를 가져와 값만 바꾸면 수정은 끝난다.!
//
////            System.out.println("=========================");

//            // Case4. 엔티티 삭제
//            Member member = em.find(Member.class, 110L); // select
//            em.remove(member);
//            System.out.println("-----------------------------");
//            tx.commit(); // delete
//            // Q. remove() 시에 엔티티를 바로 삭제할까? X
//            // 삭제 쿼리를 쓰기 지연 SQL에 등록 ==> 트랜잭션 커밋 ==> 플러시 호출 ==> 실제 DB에 삭제 쿼리를 전달


            // 플러시
            // - 영속성 컨텍스트의 변경 내용을 데이터베이스에 반영
            // - 영속성 컨텍스트를 비우지 않음
            // - 트랜잭션이라는 작업 단위가 중요 -> 커밋 직전에만 동기화 수행하기

            // 플러시 실행 시 동작 과정
            // 1. 변경 감지 동작 --> 영속성 컨텍스트에 있는 모든 엔티티를 스냅샷과 비교 --> 수정된 엔티티 찾음 --> 수정된 엔티티는 수정 쿼리를 만들어 쓰기 지연 SQL 저장소에 등록
            // 2. 쓰기 지연 SQL 저장소의 쿼리 --> 데이터베이스에 전송 (등록, 수정, 삭제 쿼리)

            // - 트랜잭션 커밋 시 플러시 자동 호출
            // - JPQL 쿼리 실행 시 플러시 자동 호출
            // - 직접 호출
//            Member member = new Member(200L, "member200");
//            em.persist(member);
//
//            em.flush(); // 직접 호출
//
//
//            System.out.println(" ============== ");

            // 준영속 상태
            // - 영속 상태의 엔티티가 영속성 컨텍스트에서 분리된 것
            // - 준영속 상태의 엔티티는 영속성 컨텍스트가 제공하는 기능을 사용할 수 없음

            // 준영속 상태로 만드는 방법
            // - em.detach(entity): 특정 엔티티만 준영속 상태로 전환
            // - em.clear(): 영속성 컨텍스트를 완전히 초기화
            // - em.close(): 영속성 컨텍스트를 종료

//            // 영속 -> 준영속 상태
//            Member member = em.find(Member.class, 200L);
//            member.setName("AAAAAA");
//
////            em.detach(member); // 영속성 컨텍스트에서 분리되어 더이상 JPA에서 관리하지 않음 < == UPDATE 쿼리가 날아가지 않음 .
//
//            System.out.println(" ==================== ");
//
//            em.clear(); // 영속성 컨텍스트에서 분리되어 더이상 JPA에서 관리하지 않음
//
//            Member member2 = em.find(Member.class, 200L); // 다시 새로운 영속성 컨텍스트에 올림
//
//            System.out.println(" ==================== ");

            tx.commit(); // [트랜잭션] - 커밋
        } catch (Exception e) {
            tx.rollback(); // [트랜잭션] - 롤백
        } finally {
            em.close(); // [엔티티 매니저] - 종료: 내부적으로 디비 커넥션을 물고 동작하기 때문에 사용 후엔 꼭 닫아주어야 함
        }

        emf.close(); // [엔티티 매니저 팩토리] - 종료
    }
}
