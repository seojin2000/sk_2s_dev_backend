package org.example.demoex.services;

import lombok.RequiredArgsConstructor;
import org.example.demoex.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReviewService {
    // DI, 생성자 방식 구현
    private final ReviewRepository reviewRepository;
}
