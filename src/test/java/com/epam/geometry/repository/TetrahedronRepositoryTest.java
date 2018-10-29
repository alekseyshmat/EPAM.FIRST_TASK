package com.epam.geometry.repository;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Tetrahedron;
import org.junit.Test;

public class TetrahedronRepositoryTest {
    private static final Tetrahedron FIRST_TETRAHEDRON = new Tetrahedron(new Point(-1, 2, 3),
            new Point(2, 2, 1),
            new Point(2.23, 2, 4.6),
            new Point(1.08, -0.94, 2.87));

   // private TetrahedronRepository<Tetrahedron> tetrahedronRepository = new TetrahedronRepository<>();

    {
     //   tetrahedronRepository.add(FIRST_TETRAHEDRON);
    }

    @Test
    public void shoudFindByVolume() {
//        List<Tetrahedron> result = tetrahedronRepository.findBy(new SearchVolumeGreater(Tetrahedron));
//        Assert.assertEquals(1, result);
//        Tetrahedron firstTetr = result.get(0);
//        Assert.assertEquals(FIRST_TETRAHEDRON, firstTetr);
    }
}
