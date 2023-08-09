package hellojpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "MEMBER_TABLE") // 테이블명
//@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq")
//@TableGenerator(
//        name = "MEMBER_SEQ_GENERATOR",
//        table = "MY_SEQUENCES",
//        pkColumnName = "MEMBER_SEQ", allocationSize = 1
//)
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "MEMBER_SEQ",
        initialValue = 1, allocationSize = 50
)
public class Member {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "MEMBER_SEQ_GENERATOR")
    private Long id;

    @Column(name = "name", nullable = false, length = 10) // 제약 조건 추가: name varchar(10) not null
    private String name;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

        @Temporal(TemporalType.TIMESTAMP)
        private Date createDate;

        @Temporal(TemporalType.TIMESTAMP)
        private Date lastModifiedDate;

        @Lob
        private String description;

    public Member() {
    }
}
