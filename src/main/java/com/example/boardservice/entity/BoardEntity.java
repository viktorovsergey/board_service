package com.example.boardservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "board", schema = "public")

public class BoardEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String boardName;
    private String serialNumber;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BoardStatus boardStatus;

    @OneToMany(mappedBy = "board")
    @ToString.Exclude
    private List<BoardHistoryEntity> boardHistoryEntityList;

    @Override
    public final boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        Class<?> oEffectiveClass = object instanceof HibernateProxy ? ((HibernateProxy) object).getHibernateLazyInitializer().getPersistentClass() : object.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        BoardEntity that = (BoardEntity) object;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

}

