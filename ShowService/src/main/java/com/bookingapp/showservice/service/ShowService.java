package com.bookingapp.showservice.service;

import com.bookingapp.showservice.entity.Show;
import com.bookingapp.showservice.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;

    public Show createShow(Show show) {
        show = showRepository.save(show);

        // Update Redis Cache
        redisTemplate.opsForHash().put("SHOW", show.getId().toString(), show);

        // Update Elasticsearch Index
        elasticsearchTemplate.index(new IndexQueryBuilder()
                .withId(show.getId().toString())
                .withObject(show)
                .build());

        return show;
    }

    public Show updateShow(Long id, Show show) {
        show.setId(id);
        show = showRepository.save(show);

        // Update Redis Cache
        redisTemplate.opsForHash().put("SHOW", show.getId().toString(), show);

        // Update Elasticsearch Index
        elasticsearchTemplate.index(new IndexQueryBuilder()
                .withId(show.getId().toString())
                .withObject(show)
                .build());

        return show;
    }

    public void deleteShow(Long id) {
        showRepository.deleteById(id);

        // Remove from Redis Cache
        redisTemplate.opsForHash().delete("SHOW", id.toString());

        // Remove from Elasticsearch Index
        elasticsearchTemplate.delete(id.toString(), Show.class);
    }

    public Show getShowById(Long id) {
        Show show = (Show) redisTemplate.opsForHash().get("SHOW", id.toString());
        if (show == null) {
            show = showRepository.findById(id).orElse(null);
            if (show != null) {
                redisTemplate.opsForHash().put("SHOW", id.toString(), show);
            }
        }
        return show;
    }

    public List<Show> getShowsByTheatreId(Long theatreId) {
        List<Show> shows = showRepository.findByTheatreId(theatreId);
        return shows;
    }
}
